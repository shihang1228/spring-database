package com.baldurtech.dbManager.admin;

import com.baldurtech.entity.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper
{
    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Department depart = new Department();
        depart.setId(rs.getLong("id"));
        depart.setName(rs.getString("name"));
        depart.setMemo(rs.getString("memo"));
        depart.setParent(rs.getString("parent"));
        depart.setAddress(rs.getString("address"));
        
        return depart;
    }
}