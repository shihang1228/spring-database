package com.baldurtech.dbManager;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DbManager
{
    public DataSource driverManager()
    {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setPassword("");
        return dataSource;
    }
}