package com.ev.workshop.api.tractorworkshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController
{
    @GetMapping( "/login" )
    public String login()
    {
        return "login";
    }


    @GetMapping("/index")
    public String indexPage()
    {
        return "index";
    }

    @GetMapping("/customer")
    public String customerPage()
    {
        return "customer";
    }

    @GetMapping("/employee")
    public String employeePage()
    {
        return "employee";
    }

}
