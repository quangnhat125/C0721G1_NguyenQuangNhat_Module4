package com.codegym.i18ncustomermanagement.controller;

import com.codegym.i18ncustomermanagement.model.Customer;
import com.codegym.i18ncustomermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customer",customerList);
        return modelAndView;
    }
}
