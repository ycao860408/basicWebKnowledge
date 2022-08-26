package com.atguigu.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "printServlet", value = "/printServlet")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n");
        writer.write( "<html lang=\"en\">\n");
        writer.write("<html lang=\"en\">\n");
        writer.write("<head>\n");
        writer.write("    <meta charset=\"UTF-8\">\n");
        writer.write("    <title>hello_world</title>\n");
        writer.write("</head>\n");
        writer.write("<body>\n");
        writer.write("hello world!\n");
        writer.write("</body>\n");
        writer.write("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
