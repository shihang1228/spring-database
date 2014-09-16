package com.baldurtech;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.baldurtech.controller.ContactController;

public class ContactControllerTest
{
    MockMvc mockMvc;
    ContactController contactController = new ContactController();
    
    @Before
    public void setup()
    {
        this.mockMvc = standaloneSetup(contactController).build();
    }
    
    @Test
    public void contactList() throws Exception
    {
        mockMvc.perform(get("/contact/list"))
        .andDo(print())
        .andExpect(content().string("contactList"));
    }
}