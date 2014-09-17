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

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application 
{
    public static void main(String[] args) 
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManager());
        
        System.out.println("Creating tables");
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
    
    public static List<Contact> executeQuery(JdbcTemplate jdbcTemplate)
    {
        String sql = "SELECT * FROM contacts WHERE name = ?";
        Object[] params = new Object[] {"shihang"};
        return jdbcTemplate.query(sql, params, new RowMapperImpl());      
    }
    
}

class RowMapperImpl implements RowMapper
{
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Contact contact = new Contact();
        contact.setId(rs.getLong("id"));
        contact.setName(rs.getString("name"));
        contact.setMobile(rs.getString("mobile"));
        return contact;
    }
}
