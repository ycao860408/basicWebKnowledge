package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void Test1() {
        for (int i = 0; i < 20; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            //JdbcUtils.closeConnection(conn);
        }
    }

}
