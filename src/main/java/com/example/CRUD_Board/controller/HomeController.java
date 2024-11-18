package com.example.CRUD_Board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "home";
    } 

    public void hi()
    { return;
    }
}
