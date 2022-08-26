package com.atguigu.Dao;

import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {

    public abstract int saveOrderItem(OrderItem orderItem);
    public abstract List<OrderItem> querryOrderItemByOrderId(String orderId);
}
