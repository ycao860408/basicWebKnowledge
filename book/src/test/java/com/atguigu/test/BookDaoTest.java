package com.atguigu.test;

import com.atguigu.Dao.BookDao;
import com.atguigu.Dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();
    @Test
    public void saveBook() {
        bookDao.saveBook(new Book(null, "骆驼祥子", "老舍", new BigDecimal("86.4"), 198, 9, null));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "四世同堂", "老舍", new BigDecimal("86.4"), 198, 9, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(15);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        //System.out.println(books);
        books.stream().forEach(System.out::println);
    }

    @Test
    public void queryForPageCount() {
        System.out.println(bookDao.queryForPageCount());
    }

    @Test
    public void ueryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(8, 4);
        books.stream().forEach(System.out::println);
    }

    @Test
    public void queryForPageCountByPrice() {
        System.out.println(bookDao.queryForPageCountByPrice(10, 80));
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = bookDao.queryForPageItemsByPrice(0, 4, 10, 80);
        books.stream().forEach(System.out::println);
    }
}