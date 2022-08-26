package com.atguigu.Dao;

import com.atguigu.pojo.User;

public interface UserDao {

    public abstract User queryUserByUserNameAndPassword(String username, String password);

    public abstract int saveUser(User user);

    public User queryUserByUsername(String username);
}
