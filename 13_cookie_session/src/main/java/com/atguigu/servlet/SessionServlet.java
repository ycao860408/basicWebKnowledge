package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "sessionServlet", value = "/sessionServlet")
public class SessionServlet extends BaseServlet {
    Random rand = new Random();
    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        boolean isNew = session.isNew();
        String id = session.getId();
        response.getWriter().write("当前是否是新创建的 => " + isNew + "<br/>");
        response.getWriter().write("当前session的id是 => " + id + "<br/>");
    }

    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int num = rand.nextInt(1000);
        session.setAttribute("num", num);
        response.getWriter().write("随机生成的数值是： " + num);
    }

    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Object num = session.getAttribute("num");
        response.getWriter().write("获取出来的数据时： " + num);
    }

    protected  void defaultLife(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("session默认超时时长是： " + maxInactiveInterval + "秒！");
    }

    protected  void setLife3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3);
        response.getWriter().write("session设置超时时长是： " + session.getMaxInactiveInterval() + "秒！");
    }


    protected  void killSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.getWriter().write("立刻杀死当前session！");
    }

}
