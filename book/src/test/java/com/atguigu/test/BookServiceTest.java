package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    BookService bookService = new BookServiceImpl();

    @Test
    public void saveBook() {
        bookService.saveBook(new Book(null, "四世同堂","老舍", new BigDecimal("49.2"), 1000, 9, null));
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "骆驼祥子", "老舍", new BigDecimal("48.3"), 1200, 3, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().stream().forEach(System.out::println);
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(3, 4);
        page.getItems().stream().forEach(System.out::println);
    }

    @Test
    public void pageByPrice() {
        Page<Book> bookPage = bookService.pageByPrice(3, 4, 10, 80);
        System.out.println(bookPage);
    }
}