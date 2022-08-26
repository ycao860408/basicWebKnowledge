package com.atguigu.Dao.impl;

import com.atguigu.Dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int saveBook(Book book) {
        String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values (?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?, `price`=?, `author`=?, `sales`=?, `stock`=?, `img_path`=? where `id`=?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where `id`=?";
        return update(sql,id);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`, `name`, `price`, `author`, `sales`, `stock`, `img_path` imgPath from t_book where `id`=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `name`, `price`, `author`, `sales`, `stock`, `img_path` imgPath,`id` from t_book";
        return queryForMany(Book.class, sql);
    }

    @Override
    public Integer queryForPageCount() {
        String sql = "select count(*) from t_book";
        return new Integer(queryForScalar(sql).toString());
    }

    @Override
    public List<Book> queryForPageItems(Integer begin, Integer pageSize) {
        String sql = "select `name`, `price`, `author`, `sales`, `stock`, `img_path` imgPath,`id` from t_book limit ? , ?";
        return queryForMany(Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageCountByPrice(Integer min, Integer max) {
        String sql = "select count(*) from t_book where `price` between ? and ?";
        return new Integer(queryForScalar(sql, min, max).toString());
    }

    @Override
    public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max) {
        String sql = "select `name`, `price`, `author`, `sales`, `stock`, `img_path` imgPath,`id` from t_book where `price` between ? and ? order by `price` limit ? , ?";
        return  queryForMany(Book.class, sql, min, max, begin, pageSize);
    }
}
