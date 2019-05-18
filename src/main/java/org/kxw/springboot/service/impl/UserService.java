package org.kxw.springboot.service.impl;

import org.kxw.springboot.dao.UserDao;
import org.kxw.springboot.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public boolean login(String username, String password) {
        return false;
    }
}
