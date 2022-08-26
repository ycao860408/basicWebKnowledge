package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();
    static {

        try {
            Properties prop = new Properties();
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(resourceAsStream);
            resourceAsStream.close();
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        Connection conn = conns.get();
        if (conn != null) return conn;
        try {
            conn = dataSource.getConnection();
            conns.set(conn);
            conn.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }


    public static void commitAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                conn.commit();
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        conns.remove();
    }

    public static void rollBackAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        conns.remove();
    }

    /*public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }*/

}
