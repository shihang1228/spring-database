package com.baldurtech.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import com.baldurtech.dbManager.admin.DbManager;
import com.baldurtech.dbManager.admin.RowMapperImpl;

import com.baldurtech.entity.Department;

@EnableAutoConfiguration
@Controller
@RequestMapping("admin/depart")
public class AdminDepartController
{
    @RequestMapping(value = "create", method = RequestMethod.GET)
    private String createDepart()
    {
        return "admin/createDepart";
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    private String createDepart(@RequestParam("name") String name,
                                @RequestParam("memo") String memo,
                                @RequestParam("address") String address,
                                @RequestParam("parent") String parent, Model model)
    {
        DbManager dbManager = new DbManager();
        Department depart = new Department();
        depart.setName(name);
        depart.setAddress(address);
        depart.setMemo(memo);
        depart.setParent(parent);
        
        dbManager.insert(depart);
        return "redirect:departList";
    }
   
}