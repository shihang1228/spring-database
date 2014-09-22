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
        contact.setVpmn(rs.getString("vpmn"));
        contact.setEmail(rs.getString("email"));
        contact.setOfficeAddress(rs.getString("office_address"));
        contact.setHomeAddress(rs.getString("home_address"));
        contact.setJob(rs.getString("job"));
        contact.setJobLevel(rs.getLong("job_level"));
        contact.setMemo(rs.getString("memo"));
        return contact;
    }
}