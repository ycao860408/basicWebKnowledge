package com.atguigu.test;

import com.atguigu.Dao.OrderItemDao;
import com.atguigu.Dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        // public OrderItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice, String orderId)
        OrderItem orderItem = new OrderItem(null, "haha", 2, new BigDecimal("24"), new BigDecimal("72"), "0312345");
        System.out.println(orderItemDao.saveOrderItem(orderItem));
    }

    @Test
    public void querryOrderItemByOrderId() {
        List<OrderItem> orderItems = orderItemDao.querryOrderItemByOrderId("0312345");
        System.out.println(orderItems);
    }
}