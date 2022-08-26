package com.atguigu.service.impl;

import com.atguigu.Dao.BookDao;
import com.atguigu.Dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);


        Integer pageCount = bookDao.queryForPageCount();
        page.setPageCount(pageCount);
        Integer pageTotal =  (int)Math.ceil(1.0 * pageCount / pageSize);
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Book> items = bookDao.queryForPageItems((page.getPageNo() - 1) * page.getPageSize(), page.getPageSize());
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);


        Integer pageCount = bookDao.queryForPageCountByPrice(min, max);
        page.setPageCount(pageCount);
        Integer pageTotal =  (int)Math.ceil(1.0 * pageCount / pageSize);
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Book> items = bookDao.queryForPageItemsByPrice((page.getPageNo() - 1) * page.getPageSize(), page.getPageSize(), min, max);
        page.setItems(items);
        return page;
    }
}
