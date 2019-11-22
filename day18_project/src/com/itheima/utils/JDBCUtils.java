package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {

    private static DataSource dataSource  = new ComboPooledDataSource();
    //1.获取连接池对象
    public static DataSource getDataSource(){
        return dataSource;
    }


    //2.获取连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
