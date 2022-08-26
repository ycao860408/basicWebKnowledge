package com.atguigu.Dao.impl;

import com.atguigu.Dao.OrderItemDao;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends  BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item (`id`, `name`, `count`, `price`, `total_price`, `order_id`) values (?, ?, ?, ?, ?, ?)";
        return update(sql, orderItem.getId(), orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> querryOrderItemByOrderId(String orderId) {
        String sql = "select `id`, `name`, `count`, `price`, `total_price` totalPrice, `order_id` orderId from t_order_item where order_id=?";
        return queryForMany(OrderItem.class, sql, orderId);
    }
}
