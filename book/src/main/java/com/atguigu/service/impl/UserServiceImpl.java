package com.atguigu.service.impl;

import com.atguigu.Dao.UserDao;
import com.atguigu.Dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        User user = userDao.queryUserByUsername(username);
        if (user == null) return false;
        return true;
    }
}
