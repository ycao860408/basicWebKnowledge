package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends BaseServlet {
    protected void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("haha");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("ycao".equalsIgnoreCase(username) && "12345".equals(password)) {
            System.out.println("Successful!");
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(300);
            response.addCookie(cookie);
        } else {
            System.out.println("Failed!");
        }
    }
}
