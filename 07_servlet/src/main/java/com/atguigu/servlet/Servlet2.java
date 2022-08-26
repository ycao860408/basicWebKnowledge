package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet2", value = "/servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("servlet2 check the username => " + username);
        Object attribute1 = request.getAttribute("key1");
        System.out.println("stamp1 from servlet1 ==> " + attribute1);
        Object attribute2 = request.getAttribute("key2");
        System.out.println("stamp2 from servlet1 ==> " + attribute2);
        System.out.println("deal with the business of servlet2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
