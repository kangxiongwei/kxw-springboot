package org.kxw.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.kxw.springboot.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 根据名称获取用户
     *
     * @param username
     * @return
     */
    User getUser(@Param("username") String username);


}
