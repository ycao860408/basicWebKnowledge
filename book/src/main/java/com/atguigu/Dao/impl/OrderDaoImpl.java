package com.atguigu.Dao.impl;

import com.atguigu.Dao.OrderDao;
import com.atguigu.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order (`order_id`, `create_time`, `price`, `state`, `user_id`) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "select `order_id` orderId, `create_time` createTime,`price`,`state` status, `user_id` userId from t_order where `user_id`= ?";
        return queryForMany(Order.class, sql, userId);
    }

    @Override
    public int changeOrderStatus(String orderId, Integer status) {
        String sql = "update t_order set state = ? where order_id = ?";
        return update(sql, status, orderId);
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select `order_id` orderId, `create_time` createTime,`price`,`state` status, `user_id` userId from t_order";
        return queryForMany(Order.class, sql);
    }

    @Override
    public Integer queryForPageCount(Integer userId) {
        String sql = "select count(*) from t_order where user_id=?";
        return new Integer(queryForScalar(sql, userId).toString());
    }

    @Override
    public List<Order> queryForPageItems(Integer userId, Integer begin, Integer pageSize) {
        String sql = "select `order_id` orderId, `create_time` createTime,`price`,`state` status, `user_id` userId from t_order where `user_id`= ? limit ?, ?";
        return queryForMany(Order.class, sql, userId, begin, pageSize);
    }
}
