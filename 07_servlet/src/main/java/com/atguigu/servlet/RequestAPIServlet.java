package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestAPIServlet", value = "/requestAPIServlet")
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resource path: " + request.getRequestURI());
        System.out.println("absolute path: " + request.getRequestURL());
        System.out.println("ip address of the client: " + request.getRemoteAddr());
        System.out.println("the http header: " + request.getHeader("Host"));
        System.out.println("the http header: " + request.getHeader("Accept"));
        System.out.println("the http header: " + request.getHeader("User-Agent"));
        System.out.println("the http header: " + request.getHeader("Connection"));
        System.out.println("the method of the request: " + request.getMethod());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
