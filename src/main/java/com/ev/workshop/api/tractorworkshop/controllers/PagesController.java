package com.ev.workshop.api.tractorworkshop.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/so")
    public String serviceOrderPage()
    {
        return "solist";
    }

    @GetMapping("/addso")
    public String createServiceOrder()
    {
        return "createos";
    }

    @GetMapping("/addso/{id}")
    public String editServiceOrder( @PathVariable( value = "id") Integer id, Model model )
    {
        model.addAttribute("soId", id );
        return "createos";
    }

    @GetMapping("/addProduct/{id}")
    public String addProducts( @PathVariable( value = "id" ) Integer id, Model model )
    {
        model.addAttribute("soId", id );
        return "soproducts";
    }
    @GetMapping("/charts")
    public String chartPage()
    {
        return "charts";
    }

}
