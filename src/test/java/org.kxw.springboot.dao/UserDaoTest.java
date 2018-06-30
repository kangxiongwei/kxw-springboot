package org.kxw.springboot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kxw.springboot.model.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void testGetUser() {
        User user = this.userDao.getUser("heilongjiang");
        System.out.println(user.getName() + "," + user.getPassword());
    }

}
