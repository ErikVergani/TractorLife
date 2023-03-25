package com.ev.workshop.api.tractorworkshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController
{
    @GetMapping( "/login" )
    public String login()
    {
        return "login";
    }

    @PostMapping( "/menu" )
    public String toString() {
        return "menu";
    }
}
