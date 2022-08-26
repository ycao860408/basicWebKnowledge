package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {

    public abstract void saveBook(Book book);
    public abstract void updateBook(Book book);
    public abstract void deleteBookById(Integer id);
    public abstract Book queryBookById(Integer id);
    public abstract List<Book> queryBooks();
    public abstract Page<Book> page(Integer pageNo, Integer pageSize);

    public abstract Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max);
}
