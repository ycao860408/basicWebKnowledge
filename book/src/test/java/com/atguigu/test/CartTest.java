package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "what so ever", 12, new BigDecimal("2"), new BigDecimal("24")));
        cart.addItem(new CartItem(2, "haha", 13, new BigDecimal("3"), new BigDecimal("39")));
        cart.addItem(new CartItem(1, "what so ever", 22, new BigDecimal("2"), new BigDecimal("44")));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "what so ever", 12, new BigDecimal("2"), new BigDecimal("24")));
        cart.addItem(new CartItem(2, "haha", 13, new BigDecimal("3"), new BigDecimal("39")));
        cart.addItem(new CartItem(1, "what so ever", 22, new BigDecimal("2"), new BigDecimal("44")));
        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "what so ever", 12, new BigDecimal("2"), new BigDecimal("24")));
        cart.addItem(new CartItem(2, "haha", 13, new BigDecimal("3"), new BigDecimal("39")));
        cart.addItem(new CartItem(1, "what so ever", 22, new BigDecimal("2"), new BigDecimal("44")));
        cart.updateCount(2, 3);
        System.out.println(cart);
    }

    @Test
    public void clean() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "what so ever", 12, new BigDecimal("2"), new BigDecimal("24")));
        cart.addItem(new CartItem(2, "haha", 13, new BigDecimal("3"), new BigDecimal("39")));
        cart.addItem(new CartItem(1, "what so ever", 22, new BigDecimal("2"), new BigDecimal("44")));
        cart.updateCount(2, 3);
        System.out.println(cart);
        cart.clean();
        System.out.println(cart);
    }
}