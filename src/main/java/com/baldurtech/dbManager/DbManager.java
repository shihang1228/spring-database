package com.baldurtech.dbManager;

import com.baldurtech.entity.Contact;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbManager
{
    JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManager());
    public DataSource driverManager()
    {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setPassword("");
        return dataSource;
    }
    
    public void createTable()
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
    
    public Contact insert(Contact contact)
    {
        String sql = "INSERT INTO contact(name, mobile, email, vpmn, office_address, home_address, memo, job, job_level) values(?,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[] {contact.getName(), contact.getMobile(), contact.getEmail(), contact.getVpmn(), contact.getOfficeAddress(), contact.getHomeAddress(), contact.getMemo(), contact.getJob(), contact.getJobLevel()};
        jdbcTemplate.update(sql, params);
        return contact;
    }
    
    public Contact update(Contact contact)
    {
        String sql = "UPDATE contact SET name=?, mobile=?, email=?, vpmn=?, office_address=?, home_address=?, memo=?, job=?, job_level=? WHERE id=?";
        Object[] params = new Object[] {contact.getName(), contact.getMobile(), contact.getEmail(), contact.getVpmn(), contact.getOfficeAddress(), contact.getHomeAddress(), contact.getMemo(), contact.getJob(), contact.getJobLevel(), contact.getId()};
        jdbcTemplate.update(sql, params);
        return contact;
    }
    
    public void delete(Contact contact)
    {
        String sql = "DELETE FROM contact WHERE id=?";
        Object[] params = new Object[] {contact.getId()};
        jdbcTemplate.update(sql, params);
    }
    
    public List<Contact> executeQuery()
    {
        String sql = "SELECT * FROM contact";  
        Object[] params = new Object[] {};
        return jdbcTemplate.query(sql, params, new RowMapperImpl());      
    }
    
    public Contact executeQueryById(Contact contact)
    {
        String sql = "SELECT * FROM contact WHERE id=?";
        Object[] params = new Object[] {contact.getId()};       
        List<Contact> result = jdbcTemplate.query(sql, params, new RowMapperImpl());
        if(result.isEmpty())
        {
            return null;
        }
        return result.get(0);
    }
    
}