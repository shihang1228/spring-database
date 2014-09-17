package com.baldurtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.baldurtech.entity.Contact;
import com.baldurtech.dbManager.DbManager;
import com.baldurtech.dbManager.RowMapperImpl;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(Application.class);
        DbManager dbManager = new DbManager();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dbManager.driverManager());
        
        System.out.println("Creating tables");
        dbManager.insert(jdbcTemplate);
        System.out.println("executeQuery");
        
        List<Contact> results = dbManager.executeQuery(jdbcTemplate);  
        
        for(Contact contact: results)
        {
            System.out.println(contact);
        }
    }
}
