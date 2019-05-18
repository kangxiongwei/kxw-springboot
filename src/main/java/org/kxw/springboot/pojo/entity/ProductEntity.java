package org.kxw.springboot.pojo.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Create by kangxiongwei on 2019/5/18 12:31 PM
 */
@Data
@Alias("product")
public class ProductEntity implements Serializable {

    private Long id;
    private String productName;
    private int stock;
    private long price;
    private int version;
    private String remark;

}
