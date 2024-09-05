package com.ssg.springex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class testHikariCP {
    @Test
    public void testHikari() throws Exception{
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/ssgdatabase?serverTimezone=UTC");
        hikariConfig.setUsername("");
        hikariConfig.setPassword("");
        hikariConfig.addDataSourceProperty("cachePrespStmts","true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize","250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit","2048");

        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();
    }
}
