package com.baldurtech.controller;

import java.util.List;
import com.baldurtech.dbManager.DbManager;
import com.baldurtech.entity.Contact;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping(value = "show",method = RequestMethod.GET)
    private String show(@RequestParam("id") Long id, Model model)
    {
        DbManager dbManager = new DbManager();
        Contact contact = new Contact();
        contact.setId(id);
        model.addAttribute("contact", dbManager.executeQueryById(contact));
        return "admin/show";
    }
    
    @RequestMapping(value="show",method = RequestMethod.POST)
    private String update(@RequestParam(value="id") String id,
                          @RequestParam(value="name") String name,
                          @RequestParam(value="mobile") String mobile,
                          @RequestParam(value="email") String email,
                          @RequestParam(value="vpmn") String vpmn,
                          @RequestParam(value="home_address") String homeAddress,
                          @RequestParam(value="office_address") String officeAddress,
                          @RequestParam(value="job") String job,
                          @RequestParam(value="job_level") String jobLevel,
                          @RequestParam(value="memo") String memo, 
                          @RequestParam(value="action") String action, Model model)
    {
        DbManager dbManager = new DbManager();
        Contact contact = new Contact();
        if("update".equals(action))
        {            
            contact.setId(Long.valueOf(id));
            contact.setName(name);
            contact.setMobile(mobile);
            contact.setEmail(email);
            contact.setVpmn(vpmn);
            contact.setHomeAddress(homeAddress);
            contact.setOfficeAddress(officeAddress);
            contact.setJob(job);
            contact.setJobLevel(Long.valueOf(jobLevel));
            contact.setMemo(memo);
            
            model.addAttribute(dbManager.update(contact));
        }
        else if("delete".equals(action))
        {
            contact.setId(Long.valueOf(id));
            dbManager.delete(contact);
        }
        return "save";
    }
    
}