package com.baldurtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.baldurtech.entity.Contact;
import com.baldurtech.dbManager.RowMapperImpl;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application 
{
    public static void main(String[] args) 
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManager());
        
        System.out.println("Creating tables");
        insert(jdbcTemplate);
        System.out.println("executeQuery");
        
        List<Contact> results = executeQuery(jdbcTemplate);  
        
        for(Contact contact: results)
        {
            System.out.println(contact);
        }
    }
    
    public static DataSource driverManager()
    {
        SpringApplication.run(Application.class);
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setPassword("");
        return dataSource;
    }
    
    public static void insert(JdbcTemplate jdbcTemplate)
    {
        jdbcTemplate.execute("drop table if exists contacts");
        jdbcTemplate.execute("create table contacts(" +
                "id serial, name varchar(255), mobile varchar(255))");
                            
        System.out.println("Inserting contact record for");
        
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 1L, "shihang", "123");
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 2L, "xiaobai", "234");
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 3L, "renjian", "345");
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 4L, "yufei", "456");
        jdbcTemplate.update("INSERT INTO contacts(id,name,mobile) values(?,?,?)", 5L, "shuangshuang", "678");
    }
    
    public static List<Contact> executeQuery(JdbcTemplate jdbcTemplate)
    {
        String sql = "SELECT * FROM contacts";  
        Object[] params = new Object[] {};
        return jdbcTemplate.query(sql, params, new RowMapperImpl());      
    }
    
}
