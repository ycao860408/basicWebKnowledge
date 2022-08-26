package com.atguigu.Dao;

import com.atguigu.pojo.Order;

import java.util.List;

public interface OrderDao {

    public abstract int saveOrder(Order order);
    public abstract List<Order> queryOrdersByUserId(Integer userId);
    public abstract int  changeOrderStatus(String orderId, Integer status);
    public abstract List<Order> queryOrders();
    public abstract Integer queryForPageCount(Integer userId);
    public abstract List<Order> queryForPageItems(Integer userId, Integer begin , Integer pageSize);
}
