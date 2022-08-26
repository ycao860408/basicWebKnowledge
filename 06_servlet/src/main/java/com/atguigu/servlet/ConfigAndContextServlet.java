package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConfigAndContextServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String username = config.getInitParameter("username");
        System.out.println("init-parameter: username => " + username);
        ServletContext context = config.getServletContext();
        System.out.println("The ServletContext of this project is " + context);
        System.out.println("The project path of the whole project is " + context.getContextPath());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("The doGet method from ConfigAndContextServlet");
        ServletContext servletContext = getServletContext();
        String username = servletContext.getInitParameter("username");
        System.out.println("context-parameter: username => " + username);
        /*get the project path*/
        String contextPath = servletContext.getContextPath();
        System.out.println("The project path of the whole project is " + contextPath);
        /*get the path of the project in the disk!*/
        String realPath = servletContext.getRealPath("/");
        System.out.println("The real path of the project on the disk is " + realPath);
        System.out.println(servletContext.getRealPath("/css/test.css"));
        System.out.println(servletContext.getRealPath("/imgs/19.jpg"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("The doPost method from ConfigAndContextServlet");
    }
}
