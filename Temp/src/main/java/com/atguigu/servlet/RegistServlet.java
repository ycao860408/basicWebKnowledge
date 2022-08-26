package com.atguigu.servlet;

import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/registServlet")
public class RegistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        //req.getRequestDispatcher("/ok.jsp").forward(req, resp);
        String attribute = (String)req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        if (attribute != null && attribute.equals(code)) {
            System.out.println("data has been saved in the DB");
            resp.sendRedirect(req.getContextPath() + "/ok.jsp");
        } else {
            System.out.println("code is not correct!");
            resp.getWriter().write("验证码不对，不要调皮！");
        }

    }
}
