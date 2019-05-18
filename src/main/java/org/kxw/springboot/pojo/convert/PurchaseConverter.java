package org.kxw.springboot.pojo.convert;

import org.kxw.springboot.pojo.entity.ProductEntity;
import org.kxw.springboot.pojo.entity.PurchaseRecordEntity;

/**
 * Create by kangxiongwei on 2019/5/18 2:44 PM
 */
public class PurchaseConverter {

    public static PurchaseRecordEntity convertToEntity(Long userId, ProductEntity product, Integer quantity) {
        PurchaseRecordEntity entity = new PurchaseRecordEntity();
        entity.setUserId(userId);
        entity.setProductId(product.getId());
        entity.setPrice(product.getPrice());
        entity.setQuantity(quantity);
        entity.setTotalPrice(product.getPrice() * quantity);
        entity.setRemark("购买日志，时间：" + System.currentTimeMillis());
        return entity;
    }


}
