package com.atguigu.test;

import com.atguigu.Dao.UserDao;
import com.atguigu.Dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUserNameAndPassword() {
        User admin = userDao.queryUserByUserNameAndPassword("admin", "admin");
        if (admin == null) {
            System.out.println("Logging Failed");
        } else {
            System.out.println("Logging Successfully");
        }
    }

    @Test
    public void saveUser() {
        /*userDao.saveUser(new User( null, "LianLian", "7867", "nicole@qq.com"));
        userDao.saveUser(new User( null, "Pianpian ", "7867", "tommy@qq.com"));*/
    }

    @Test
    public void queryUserByUsername() {
        User tiantian = userDao.queryUserByUsername("tiantian");
        if (tiantian != null) {
            System.out.println("this name has been used!");
        } else {
            System.out.println("This name can be used!");
        }
    }
}