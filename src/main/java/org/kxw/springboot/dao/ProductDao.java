package org.kxw.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.kxw.springboot.pojo.entity.ProductEntity;

/**
 * Create by kangxiongwei on 2019/5/18 12:42 PM
 */
@Mapper
public interface ProductDao {

    /**
     * 根据id查询商品信息
     *
     * @param id
     * @return
     */
    ProductEntity getProduct(Long id);

    /**
     * 悲观锁
     *
     * @param id
     * @return
     */
    ProductEntity getProductByPessimism(Long id);

    /**
     * 给指定商品扣减库存
     *
     * @param id
     * @param quantity
     * @return
     */
    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);

    /**
     * 乐观锁
     *
     * @param id
     * @param quantity
     * @return
     */
    int decreaseProductByOptimism(@Param("id") Long id, @Param("quantity") int quantity, @Param("version") int version);

}
