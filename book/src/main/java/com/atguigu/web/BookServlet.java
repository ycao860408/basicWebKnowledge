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
import java.util.List;

@WebServlet(name = "BookServlet", value = "/manager/bookServlet")
public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.copy2Bean(new Book(), request.getParameterMap());
        bookService.saveBook(book);
        response.sendRedirect(request.getContextPath() +"/manager/bookServlet?action=page&pageNo=" + Integer.MAX_VALUE);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        //System.out.println("delete" + id);
        bookService.deleteBookById(id);
        response.sendRedirect(request.getContextPath() +"/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }

    protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        //System.out.println("byId" + id);
        Book book = bookService.queryBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        Book book = WebUtils.copy2Bean(new Book(), request.getParameterMap());
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath() +"/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

}
