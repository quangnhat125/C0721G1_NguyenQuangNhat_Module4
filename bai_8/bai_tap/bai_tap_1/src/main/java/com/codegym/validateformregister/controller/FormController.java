package com.codegym.validateformregister.controller;

import com.codegym.validateformregister.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")
public class FormController {

    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/views/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@ModelAttribute @Validated User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/views/index");
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        } else {
            ModelAndView modelAndView1 = new ModelAndView("/views/result");
            modelAndView1.addObject("user", user);
            return modelAndView1;
        }
    }
}

