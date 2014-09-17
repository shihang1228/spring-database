package com.baldurtech.dbManager;

import com.baldurtech.entity.Contact;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

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
    
    public void insert(JdbcTemplate jdbcTemplate)
    {
        jdbcTemplate.execute("drop table if exists contacts");
        jdbcTemplate.execute("create table contacts(" +
                "id serial, name varchar(255), mobile varchar(255))");
                            
        System.out.println("Inserting contact record!");
        
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 1L, "shihang", "123");
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 2L, "xiaobai", "234");
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 3L, "renjian", "345");
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 4L, "yufei", "456");
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 5L, "shuangshuang", "678");
    }
    
    public List<Contact> executeQuery(JdbcTemplate jdbcTemplate)
    {
        String sql = "SELECT * FROM contacts";  
        Object[] params = new Object[] {};
        return jdbcTemplate.query(sql, params, new RowMapperImpl());      
    }
}