package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {

    public abstract void registerUser(User user);

    public User login(User user);

    public boolean existsUsername(String username);
}
