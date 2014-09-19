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
        /*DbManager dbManager = new DbManager();
        System.out.println("executeQuery");
        
        List<Contact> results = dbManager.executeQuery();  
        
        for(Contact contact: results)
        {
            System.out.println(contact);
        }*/
        DbManager dbManager = new DbManager();
        
        Contact contact = new Contact();
        contact.setId(14L);
        contact.setName("mengguizhen");
        contact.setMobile("18235408753");
        contact.setEmail("123@qq.com");
        contact.setHomeAddress("shanxi");
        contact.setOfficeAddress("taiyuan");
        contact.setMemo("zanwu");
        contact.setJob("HR");
        contact.setJobLevel(3L);
        
        dbManager.delete(contact);
        System.out.println(contact);
        
    }
}
