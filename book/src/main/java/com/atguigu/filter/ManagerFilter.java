package com.atguigu.filter;

import com.atguigu.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = {"/pages/manager/*", "/manager/bookServlet"})
public class ManagerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
        } else if (!"admin".equals(user.getUsername())) {
            req.getRequestDispatcher("/pages/errorPage/magError.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
