package com.atguigu.Dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {

    public abstract int saveBook(Book book);
    public abstract int updateBook(Book book);
    public abstract int deleteBookById(Integer id);
    public abstract Book queryBookById(Integer id);
    public abstract List<Book> queryBooks();
    public abstract Integer queryForPageCount();
    public abstract List<Book> queryForPageItems(Integer begin, Integer pageSize);
    public abstract Integer queryForPageCountByPrice(Integer min, Integer max);
    public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max);
}
