package com.atguigu.el_jstl;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sun.java2d.pipe.SpanIterator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "uploadServlet", value = "/uploadServlet")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem file : list) {
                    if (file.isFormField()) {
                        System.out.println(file.getFieldName() + " : " + file.getString("UTF-8"));
                    } else {
                        System.out.println("Form Field Name: " + file.getFieldName());
                        System.out.println("FileName: " + file.getName());
                        file.write(new File("D:\\doufu\\develops\\JavaWeb0621\\09_el_jstl\\src\\main\\webapp\\document\\" + file.getName()));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
