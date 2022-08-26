package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet1", value = "/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("Check the stamp from servlet1 => " + username);
        request.setAttribute("key1", "stamp1 from servlet1");
        request.setAttribute("key2", "stamp2 from servlet1");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        //request.getRequestDispatcher("/WEB-INF/a.html")
        System.out.println("path to the servlet2 => " + requestDispatcher);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
