package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("Method in constructor");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter method!");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("initial method!");
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("username"));
        System.out.println(filterConfig.getServletContext().getInitParameter("username"));
    }

    @Override
    public void destroy() {
        System.out.println("destroy method!");
    }
}
