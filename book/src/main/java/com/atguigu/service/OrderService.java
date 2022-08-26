package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.Page;

import java.util.List;

public interface OrderService {

    public abstract String createOrder(Integer userId, Cart cart);
    public abstract List<Order> myOrders(Integer userId);
    public abstract void receiveOrder(String orderId);
    public abstract List<OrderItem> orderDetails(String orderId);
    public abstract List<Order> allOrders();
    public abstract void sendOrder(String orderId);
    public abstract Page<Order> myPage(Integer userId, Integer pageNo, Integer pageSize);
}
