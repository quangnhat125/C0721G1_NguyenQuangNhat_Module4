package com.codegym.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/index")
public class Controller {
    @GetMapping("")
    public String home() {
        return "index";
    }
}
