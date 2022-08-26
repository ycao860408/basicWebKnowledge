package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "what so ever", 12, new BigDecimal("2"), new BigDecimal("24")));
        cart.addItem(new CartItem(2, "haha", 13, new BigDecimal("3"), new BigDecimal("39")));
        cart.addItem(new CartItem(1, "what so ever", 22, new BigDecimal("2"), new BigDecimal("44")));
        orderService.createOrder(1, cart);
    }

    @Test
    public void myOrders() {
        List<Order> orders = orderService.myOrders(1);
        System.out.println(orders);
    }

    @Test
    public void receiveOrder() {
        orderService.receiveOrder("1657670830101#1");
    }

    @Test
    public void orderDetails() {
        List<OrderItem> orderItems = orderService.orderDetails("1657670830101#1");
        System.out.println(orderItems);
    }

    @Test
    public void allOrders() {
        List<Order> orders = orderService.allOrders();
        System.out.println(orders);
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("1657670830101#1");
    }
}