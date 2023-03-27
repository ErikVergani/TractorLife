package com.ev.workshop.api.tractorworkshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController
{
    @GetMapping( value = "/login" , produces = "application/json")
    public String login()
    {
        return "login";
    }

    @PostMapping( "/menu" )
    public String menu() {
        return "menu";
    }
    
    @GetMapping( "/menu" )
    public String getMenu() {
        return "menu";
    }

    @GetMapping( "/customer" )
    public String customer() {
        return "customer";
    }
}
