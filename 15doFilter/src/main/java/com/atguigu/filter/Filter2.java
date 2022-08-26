package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(value = {"/target.jsp"})
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("precode2");
        System.out.println(Thread.currentThread().getName());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println(servletRequest.getParameter("username"));
        System.out.println(servletRequest.getAttribute("abc"));
        System.out.println("postcode2");
    }
}
