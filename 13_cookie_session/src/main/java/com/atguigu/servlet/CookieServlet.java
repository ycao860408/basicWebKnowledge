package com.atguigu.servlet;

import com.atguigu.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "cookieServlet", value = "/cookieServlet")
public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie1 = new Cookie("k1", "v1");
        Cookie cookie2 = new Cookie("k2", "v2");

        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.getWriter().write("cookie 已经被创建好了！");
    }


    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                response.getWriter().write("服务器收到cookie[" + cookie.getName() + " = "  + cookie.getValue() + "]<br/>");
            }
            String targetName = "k2";
            Cookie target = CookieUtils.findCookie(cookies, targetName);

            /*for  (Cookie cookie : cookies) {
                if (targetName.equals(cookie.getName())) {
                    target = cookie;
                    break;
                }
            }*/

            if (target != null) {
                response.getWriter().write("我们要找的cookie => " + targetName);
            }
        }
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*Cookie cookie = new Cookie("k2", "nv2.0");
        response.addCookie(cookie);*/
        Cookie[] cookies = request.getCookies();
        Cookie k2 = CookieUtils.findCookie(cookies, "k2");
        if (k2 != null) {
            k2.setValue("nv2.1");
            response.addCookie(k2);
            response.getWriter().write("v2的值已经被更新了！");
        } else {
            response.getWriter().write("没有要修改的cookie！");
        }

    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("k4", "v4");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        response.getWriter().write("创建了一个默认存活的Cookie！");
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie k2 = CookieUtils.findCookie(request.getCookies(), "k2");
        if(k2 != null) {
            k2.setMaxAge(0);
            response.addCookie(k2);
            response.getWriter().write("update k2's life time!");
        }
    }


    protected void life3600(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("k5", "life3600");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        response.getWriter().write("a cookie whose life is  one hour is created!");
    }

    protected void testPath(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("t1", "t1Path");
        cookie.setPath(request.getContextPath() + "/abc");
        response.addCookie(cookie);
        response.getWriter().write("创建一个带自定义path的cookie");
    }

}
