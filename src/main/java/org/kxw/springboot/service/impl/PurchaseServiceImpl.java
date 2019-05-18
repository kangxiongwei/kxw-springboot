package org.kxw.springboot.service.impl;

import org.kxw.springboot.dao.ProductDao;
import org.kxw.springboot.dao.PurchaseRecordDao;
import org.kxw.springboot.pojo.convert.PurchaseConverter;
import org.kxw.springboot.pojo.entity.ProductEntity;
import org.kxw.springboot.pojo.entity.PurchaseRecordEntity;
import org.kxw.springboot.service.PurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Create by kangxiongwei on 2019/5/18 2:39 PM
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

    @Resource
    private ProductDao productDao;
    @Resource
    private PurchaseRecordDao purchaseRecordDao;

    /**
     * 处理购买业务
     *
     * @param userId
     * @param productId
     * @param quantity
     * @return
     */
    @Transactional
    @Override
    public boolean purchase(Long userId, Long productId, Integer quantity) {
        ProductEntity product = productDao.getProduct(productId);    //高并发情况下，存在超卖现象
        //商品不存在，或者库存不足
        if (product == null || product.getStock() < quantity) {
            return false;
        }
        //减库存
        productDao.decreaseProduct(productId, quantity);
        //记录购买日志
        PurchaseRecordEntity entity = PurchaseConverter.convertToEntity(userId, product, quantity);
        purchaseRecordDao.insert(entity);
        return true;
    }

    /**
     * 乐观锁购买商品
     * <Note>这种写法，可能会存在很多购买失败的情况，可以加入重入（重试）机制，限定时间和次数，来解决失败率比较高的问题</Note>
     *
     * @param userId
     * @param productId
     * @param quantity
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public boolean purchaseByOptimism(Long userId, Long productId, Integer quantity) {
        ProductEntity product = productDao.getProduct(productId);    //高并发情况下，存在超卖现象
        //商品不存在，或者库存不足
        if (product == null || product.getStock() < quantity) {
            return false;
        }
        //乐观锁逻辑，类似于CAS
        int version = product.getVersion();
        //减库存，根据version进行比较并更新
        int result = productDao.decreaseProductByOptimism(productId, quantity, version);
        //如果更新数据失败，表示该记录被其他线程已修改
        if (result == 0) {
            return false;
        }
        //记录购买日志
        PurchaseRecordEntity entity = PurchaseConverter.convertToEntity(userId, product, quantity);
        purchaseRecordDao.insert(entity);
        return true;
    }
}
