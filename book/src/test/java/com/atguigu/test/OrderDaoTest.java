package com.atguigu.test;

import com.atguigu.Dao.OrderDao;
import com.atguigu.Dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        //  Order(String orderId, Date createTime, Integer status, BigDecimal price, Integer userId) {
        Order order = new Order("0312345", new Date(), null, new BigDecimal("13"), 2);
        System.out.println(orderDao.saveOrder(order));
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> orders = orderDao.queryOrdersByUserId(2);
        System.out.println(orders);
    }

    @Test
    public void changeOrderStatus() {
        orderDao.changeOrderStatus("0312345", 2);
        List<Order> orders = orderDao.queryOrdersByUserId(2);
        System.out.println(orders);
    }

    @Test
    public void queryOrders() {
        List<Order> orders = orderDao.queryOrders();
        System.out.println(orders);
    }
}