package com.baldurtech.controller;

import com.baldurtech.entity.User;
import com.baldurtech.entity.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


@EnableAutoConfiguration
@Controller
@RequestMapping("/contact")
public class UserController {

    @RequestMapping("/{id}")
    private String view(@PathVariable("id") Long id, @RequestParam("name") String name, Model model) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        model.addAttribute("user", user);
        return "helloWorld";
    }
    
    @RequestMapping("list")
    private String contactList(Model model) {
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setName("shihang");
        model.addAttribute("contact", contact);
        return "contactList";
    }
    
    
    
}
