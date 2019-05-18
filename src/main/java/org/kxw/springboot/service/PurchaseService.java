package org.kxw.springboot.service;

import org.springframework.stereotype.Service;

/**
 * Create by kangxiongwei on 2019/5/18 2:38 PM
 */
public interface PurchaseService {

    /**
     * 处理购买业务
     *
     * @param userId
     * @param productId
     * @param quantity
     * @return
     */
    boolean purchase(Long userId, Long productId, Integer quantity);

    /**
     * 乐观锁购买商品
     *
     * @param userId
     * @param productId
     * @param quantity
     * @return
     */
    boolean purchaseByOptimism(Long userId, Long productId, Integer quantity);

}
