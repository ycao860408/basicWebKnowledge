package com.atguigu.service.impl;

import com.atguigu.Dao.BookDao;
import com.atguigu.Dao.OrderDao;
import com.atguigu.Dao.OrderItemDao;
import com.atguigu.Dao.impl.BookDaoImpl;
import com.atguigu.Dao.impl.OrderDaoImpl;
import com.atguigu.Dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Integer userId, Cart cart) {
        // Order(String orderId, Date createTime, Integer status, BigDecimal price, Integer userId)
        String orderId = System.currentTimeMillis() + "#" + userId;
        Order order = new Order(orderId, new Date(), null, cart.getTotalPrice(), userId);
        orderDao.saveOrder(order);
        for (CartItem cartItem : cart.getItems().values()) {
            // OrderItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice, String orderId)
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
        }
        cart.clean();
        return orderId;
    }

    @Override
    public List<Order> myOrders(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 2);
    }

    @Override
    public List<OrderItem> orderDetails(String orderId) {
        return orderItemDao.querryOrderItemByOrderId(orderId);
    }

    @Override
    public List<Order> allOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 1);
    }

    @Override
    public Page<Order> myPage(Integer userId, Integer pageNo, Integer pageSize) {
        Page<Order> page = new Page<>();
        page.setPageSize(pageSize);


        Integer pageCount = orderDao.queryForPageCount(userId);
        page.setPageCount(pageCount);
        Integer pageTotal =  (int)Math.ceil(1.0 * pageCount / pageSize);
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Order> items = orderDao.queryForPageItems(userId, (page.getPageNo() - 1) * page.getPageSize(), page.getPageSize());
        System.out.println(items);
        page.setItems(items);
        return page;
    }
}
