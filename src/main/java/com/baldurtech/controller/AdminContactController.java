package com.baldurtech.controller;

import java.util.List;
import com.baldurtech.dbManager.DbManager;
import com.baldurtech.entity.Contact;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

@EnableAutoConfiguration
@Controller
@RequestMapping("admin/contact")
public class AdminContactController
{
    @RequestMapping("list")
    private String contactList(Model model)
    {
        DbManager dbManager = new DbManager();
        List<Contact> results = dbManager.executeQuery();
        model.addAttribute("contact", results);
        return "admin/contactList";   
    }
    
}