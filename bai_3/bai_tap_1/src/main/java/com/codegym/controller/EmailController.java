package com.codegym.controller;


import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping("/form")
public class EmailController {

    @GetMapping("")
    public ModelAndView emailForm() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("email", new Email());
        modelAndView.addObject("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSize", new int[] {5, 10, 15, 20, 25, 50, 100});
        return  modelAndView;
    }
}
