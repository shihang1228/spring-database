package com.baldurtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.baldurtech.entity.Contact;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(Application.class);
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:mem");
        dataSource.setPassword("");
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        System.out.println("Creating tables");
        
        jdbcTemplate.execute("drop table contact if exists");
        jdbcTemplate.execute("create table contact(" +
                "id serial, name varchar(255), mobile varchar(255))");
                            
        System.out.println("Inserting contact record for");
        
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile) values(?,?,?)", 1L, "shihang", "123");
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile) values(?,?,?)", 2L, "xiaobai", "234");
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile) values(?,?,?)", 3L, "renjian", "345");
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile) values(?,?,?)", 4L, "yufei", "456");
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile) values(?,?,?)", 5L, "shuangshuang", "678");
        
        List<Contact> results = jdbcTemplate.query("SELECT * FROM contact WHERE name = ?", new Object[] {"shihang"}, 
        new RowMapper<Contact>() 
        {
            @Override
            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                return new Contact(rs.getLong("id"), rs.getString("name"), rs.getString("mobile"));
            }
        });
        
        for(Contact contact: results)
        {
            System.out.println(contact);
        }
    }
}
