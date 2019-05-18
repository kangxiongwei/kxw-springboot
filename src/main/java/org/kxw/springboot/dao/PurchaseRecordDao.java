package org.kxw.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.kxw.springboot.pojo.entity.PurchaseRecordEntity;

/**
 * Create by kangxiongwei on 2019/5/18 12:44 PM
 */
@Mapper
public interface PurchaseRecordDao {

    /**
     * 添加购买记录
     *
     * @param record
     * @return
     */
    int insert(PurchaseRecordEntity record);

}
