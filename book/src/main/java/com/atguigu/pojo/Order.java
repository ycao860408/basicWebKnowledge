package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String orderId;
    private Date createTime;
    private Integer status = 0;
    private BigDecimal price;
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, Date createTime, Integer status, BigDecimal price, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        if (status != null) {
            this.status = status;
        }
        this.price = price;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }
}
