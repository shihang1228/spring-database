package com.baldurtech.dbManager;

import com.baldurtech.entity.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper
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