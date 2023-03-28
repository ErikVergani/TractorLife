package com.ev.workshop.api.tractorworkshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController
{
    @RequestMapping( value = "/login" )
    public String login()
    {
        return "login";
    }


    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/customer")
    public String customer()
    {
        return "customerEditor";
    }

}
