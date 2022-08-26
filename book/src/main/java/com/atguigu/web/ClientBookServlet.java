package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "client/bookServlet", value = "/client/bookServlet")
public class ClientBookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected  void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    protected  void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String minStr = request.getParameter("min");
        String maxStr = request.getParameter("max");
        System.out.println(minStr);
        System.out.println(maxStr);
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Integer min = WebUtils.parseInt(minStr, 0);
        Integer max = WebUtils.parseInt(maxStr, Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (minStr != null) {
            sb.append("&min=").append(minStr);
        }
        if (maxStr != null) {
            sb.append("&max=").append(maxStr);
        }
        page.setUrl(sb.toString());
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
