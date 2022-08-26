package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "ljj1234","123456","13844083985"));
    }

    @Test
    public void login() {
        if (userService.login(new User(null, "admin", "admin", null)) == null) {
            System.out.println("Username or Password is wrong");
        } else {
            System.out.println("successful!");
        }
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admin")) {
            System.out.println("This name cannot be used!");
        } else {
            System.out.println("This name is ready to use!");
        }
    }
}