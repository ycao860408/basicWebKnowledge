package com.atguigu.el_jstl;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "downloadServlet", value = "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "DSC_6053.JPG";
        ServletContext servletContext = getServletContext();
        InputStream input = servletContext.getResourceAsStream("/document/" + fileName);
        String mimeType = servletContext.getMimeType("/document/" + fileName);
        response.setContentType(mimeType);
        /*
        String str = "attachment, fileName=" + URLEncode.encode("中文.jpg", "UTF-8");
        response.setHeader("Content-Disposition", str);
         */
        response.setHeader("Content-Disposition", "attachment; fileName="+fileName);
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(input, output);
        input.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
