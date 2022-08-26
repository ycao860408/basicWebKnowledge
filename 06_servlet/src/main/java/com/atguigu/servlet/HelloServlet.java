package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1. This is from the constructor of the HelloServlet!");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. This is from the init function of the HelloServlet!");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3. Hello, Servlet!");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    public void doGet() {
        System.out.println("ge doGet request");
    }

    public void doPost() {
        System.out.println("get doPost request");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4. The HelloServlet is destroyed!");
    }
}
