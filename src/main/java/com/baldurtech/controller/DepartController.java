package com.baldurtech;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import com.baldurtech.entity.Department;
import com.baldurtech.dbManager.admin.DbManager;
import com.baldurtech.dbManager.admin.RowMapperImpl;

import java.util.List;

@EnableAutoConfiguration
@Controller
@RequestMapping("depart")
public class DepartController
{
    @RequestMapping("list")
    private String departList(Model model)
    {
        DbManager dbManager = new DbManager();
        List<Department> results = dbManager.executeQuery();
        model.addAttribute("depart", results);
        return "departList";
    }
}