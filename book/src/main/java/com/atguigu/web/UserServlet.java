package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "userServlet", value = "/userServlet")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    protected  void ajaxExistUsername (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Boolean exists = userService.existsUsername(username);
        Map<String, Boolean> map = new HashMap<>();
        map.put("exists", exists);
        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(map));
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String token = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        User user = WebUtils.copy2Bean(new User(), request.getParameterMap());
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(user.getUsername())) {
                request.setAttribute("msg", "用户名已存在！");
                request.setAttribute("username", user.getUsername());
                request.setAttribute("email", user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                userService.registerUser(user);
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "验证码不正确！");
            request.setAttribute("username", user.getUsername());
            request.setAttribute("email", user.getEmail());
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User tempUser = WebUtils.copy2Bean(new User(), request.getParameterMap());
        User user = userService.login(tempUser);
        if (user == null) {
            //System.out.println("Login Failed!");
            request.setAttribute("username", tempUser .getUsername());
            request.setAttribute("msg", "用户名或者密码错误！");

            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    protected  void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }
}
