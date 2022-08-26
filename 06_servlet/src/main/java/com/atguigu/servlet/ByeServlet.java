package com.atguigu.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ByeServlet implements Servlet {
    public ByeServlet() {
        System.out.println("1. This is from the constructor of the ByeServlet!");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. This is from init function of the ByeServlet!");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3. Bye Bye!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4. ByeServlet is destroyed!");
    }
}
