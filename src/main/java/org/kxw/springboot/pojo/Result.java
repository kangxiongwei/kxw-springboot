package org.kxw.springboot.pojo;

import lombok.Data;

/**
 * Create by kangxiongwei on 2019/5/18 2:33 PM
 */
@Data
public class Result {

    private boolean success = false;
    private String message = null;

    public Result() {
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
