package com.atguigu.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "searchStudentServlet", value = "/searchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> sts = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            sts.add(new Student(i + 1, "name" + i, "134phone" + i, Math.random() > 0.5 ? 1 : 0));
        }
        request.setAttribute("sts", sts);
        request.getRequestDispatcher("/showResult.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
