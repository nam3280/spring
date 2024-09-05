package com.ssg.springex.jdbcex;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {
    //ConnectionUtil 클래스는 하나의 객체를 만들어서 사용하는 방식이다.
    //HikariConfig를 이용해서 하나의 HikariDataSource를 구성한다.
    //구성된 HikariDataSource는 getConnection()을 통해서 사용된다.
    //외부에서는 ConnectionUtil.INSTANCE.getConnection()을 통해 Connection을 받을 수 있다.
    INSTANCE;
    private HikariDataSource ds;
    ConnectionUtil(){
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/ssgdatabase?serverTimezone=UTC");
        hikariConfig.setUsername("webuser");
        hikariConfig.setPassword("zxcvbnm123456");
        hikariConfig.addDataSourceProperty("cachePrespStmts","true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize","250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit","2048");

        ds = new HikariDataSource(hikariConfig);
    }

    public Connection getConnection() throws Exception{
        return ds.getConnection();
    }
}
