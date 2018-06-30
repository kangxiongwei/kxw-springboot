package org.kxw.springboot.service;

import org.kxw.springboot.dao.UserDao;
import org.kxw.springboot.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public boolean login(String username, String password) {
        User user = this.userDao.getUser(username);
        if (user == null) return false;
        return password.equals(user.getPassword());
    }
}
