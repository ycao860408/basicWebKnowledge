package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.Page;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.WebUtils;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "client/orderServlet", value = "/client/orderServlet")
public class ClientOrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        User user = (User)session.getAttribute("user");
        System.out.println(user);
        if (user == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer id = user.getId();
        System.out.println(id);
        String orderId = orderService.createOrder(id, cart);
        session.setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void myPage(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        User user = (User)request.getSession().getAttribute("user");
        Integer userId = user.getId();
        Page<Order> page = orderService.myPage(userId, pageNo, pageSize);
        page.setUrl("client/orderServlet?action=myPage");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
    }
}
