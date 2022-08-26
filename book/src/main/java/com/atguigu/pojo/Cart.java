package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Integer totalCount = 0;
    private BigDecimal totalPrice = new BigDecimal("0");
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        CartItem old = items.get(item.getId());

        CartItem newItem = new CartItem(item.getId(), item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice());
        if (old != null) {
            newItem.setCount(item.getCount() + old.getCount());
            newItem.setTotalPrice(item.getTotalPrice().add(old.getTotalPrice()));
        }
        items.put(newItem.getId(), newItem);
        this.setTotalPrice(this.getTotalPrice().add(item.getTotalPrice()));
        this.setTotalCount(this.getTotalCount() + item.getCount());
    }

    public void deleteItem(Integer id) {
        CartItem remove = items.remove(id);
        if (remove != null) {
            this.setTotalCount(this.getTotalCount() - remove.getCount());
            this.setTotalPrice(this.getTotalPrice().subtract(remove.getTotalPrice()));
        }
    }

    public void updateCount(Integer id, Integer count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
        if (items.containsKey(id)) {
            CartItem cartItem = items.get(id);
            if (cartItem.getCount() != count) {
                if (count == 0) {
                    deleteItem(id);
                } else {
                    int diff = count - cartItem.getCount();
                    cartItem.setCount(cartItem.getCount() + diff);
                    BigDecimal priceDiff = cartItem.getPrice().multiply(new BigDecimal(diff + ""));
                    cartItem.setTotalPrice(cartItem.getTotalPrice().add(priceDiff));
                    this.setTotalPrice(this.getTotalPrice().add(priceDiff));
                    this.setTotalCount(this.getTotalCount() + diff);
                }
            }
        }
    }

    public void clean() {
        this.items.clear();
        this.setTotalPrice(new BigDecimal("0"));
        this.setTotalCount(0);
    }
}
