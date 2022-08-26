package com.atguigu.Dao.impl;

import com.atguigu.Dao.UserDao;
import com.atguigu.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUserNameAndPassword(String username, String password) {
        String sql = "select `username`, `password`, `email`, `id` from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user (`username`, `password`, `email`) value(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `username`, `password`, `email`, `id` from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }
}
