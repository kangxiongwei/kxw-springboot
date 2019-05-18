package org.kxw.springboot.pojo.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Create by kangxiongwei on 2019/5/18 12:32 PM
 */
@Data
@Alias("purchaseRecord")
public class PurchaseRecordEntity {

    private Long id;
    private Long userId;
    private Long productId;
    private long price;
    private int quantity;
    private long totalPrice;
    private String remark;
    private Date addTime;

}
