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

import java.util.List;

@EnableAutoConfiguration
@Controller
@RequestMapping("admin/depart")
public class AdminDepartController
{
    @RequestMapping("list")
    private String departList(Model model)
    {
        DbManager dbManager = new DbManager();
        List<Department> results = dbManager.executeQuery();
        model.addAttribute("depart", results);
        return "admin/departList";
    }

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
        return "redirect:list";
    }
    
    @RequestMapping(value = "show",method = RequestMethod.GET)
    private String show(@RequestParam("id") Long id, Model model)
    {
        DbManager dbManager = new DbManager();
        Department depart = new Department();
        depart.setId(id);
        model.addAttribute("depart", dbManager.executeQueryById(depart));
        return "admin/departShow";
    }
    
    @RequestMapping(value="show",method = RequestMethod.POST)
    private String update(@RequestParam(value="id") String id,
                          @RequestParam(value="name") String name,
                          @RequestParam(value="address") String address,
                          @RequestParam(value="parent") String parent,
                          @RequestParam(value="memo") String memo,                          
                          @RequestParam(value="action") String action, Model model)
    {
        DbManager dbManager = new DbManager();
        Department depart = new Department();
        if("update".equals(action))
        {                  
            depart.setId(Long.valueOf(id));
            depart.setName(name);
            depart.setAddress(address);
            depart.setParent(parent);            
            depart.setMemo(memo);
            
            model.addAttribute(dbManager.update(depart));            
        }
        else if("delete".equals(action))
        {
            depart.setId(Long.valueOf(id));
            dbManager.delete(depart);            
        }
        return "redirect:list";

    }
   
}