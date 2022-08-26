package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "cartServlet", value = "/cartServlet")
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> map = new HashMap<>();
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        Map<Integer, CartItem> items = cart.getItems();
        CartItem temp = items.get(id);
        int curCount = temp == null ? 1 : temp.getCount() + 1;
        if (curCount > book.getStock()) {
            map.put("valid", false);
            response.getWriter().write(new Gson().toJson(map));
            return;
        }
        cart.addItem(cartItem);
        request.getSession().setAttribute("last", cartItem.getName());
        map.put("valid", true);
        map.put("total", cart.getTotalCount());
        map.put("last", cartItem.getName());
        response.getWriter().write(new Gson().toJson(map) );
    }
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        request.getSession().setAttribute("last", cartItem.getName() );
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void clean(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clean();
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Integer count = WebUtils.parseInt(request.getParameter("count"), 1);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
