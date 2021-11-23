package com.codegym.furamaresortcasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String showHomePage() {
        return "home1";
    }
    @GetMapping("/404")
    public String get404Page(){
        return "404";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
}
