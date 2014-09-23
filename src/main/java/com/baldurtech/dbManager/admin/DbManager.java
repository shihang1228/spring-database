package com.baldurtech.dbManager.admin;

import com.baldurtech.entity.Department;

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
    
    public Department insert(Department depart)
    {
        String sql = "INSERT INTO department(name, memo, parent, address) values(?,?,?,?)";
        Object[] params = new Object[] {depart.getName(), depart.getMemo(), depart.getParent(), depart.getAddress()};
        jdbcTemplate.update(sql, params);
        return depart;
    }
    
    public Department update(Department depart)
    {
        String sql = "UPDATE department SET name=?, memo=?, parent=?, address=? WHERE id=?";
        Object[] params = new Object[] {depart.getName(), depart.getMemo(), depart.getParent(), depart.getAddress(), depart.getId()};
        jdbcTemplate.update(sql, params);
        return depart;
    }
    
    public void delete(Department depart)
    {
        String sql = "DELETE FROM department WHERE id=?";
        Object[] params = new Object[] {depart.getId()};
        jdbcTemplate.update(sql, params);
    }
    
    public List<Department> executeQuery()
    {
        String sql = "SELECT * FROM department";  
        Object[] params = new Object[] {};
        return jdbcTemplate.query(sql, params, new RowMapperImpl());      
    }
    
    public Department executeQueryById(Department depart)
    {
        String sql = "SELECT * FROM department WHERE id=?";
        Object[] params = new Object[] {depart.getId()};       
        List<Department> result = jdbcTemplate.query(sql, params, new RowMapperImpl());
        if(result.isEmpty())
        {
            return null;
        }
        return result.get(0);
    }
    
}