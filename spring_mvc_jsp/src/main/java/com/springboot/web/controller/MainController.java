package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(){
        System.out.print("Home Page");
        return "home";
    }

    @RequestMapping("/contact")
    public String contact(){
        System.out.println("This is a contact page");
        return "contact";
    }

}
