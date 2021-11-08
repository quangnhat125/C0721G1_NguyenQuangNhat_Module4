package com.codegym.furamaresortcasestudy.controller;

import com.codegym.furamaresortcasestudy.model.Customer;
import com.codegym.furamaresortcasestudy.model.CustomerType;
import com.codegym.furamaresortcasestudy.service.ICustomerService;
import com.codegym.furamaresortcasestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerTypeService customerTypeService;
    @Autowired
    ICustomerService customerService;
    @ModelAttribute("customerTypeList")
    public Iterable<CustomerType> showListCustomerType() {
        return customerTypeService.findAll();
    }
    @GetMapping("")
    public ModelAndView showListCustomer(@PageableDefault(value = 5)Pageable pageable){
        Page<Customer> customerPage = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customer", customerPage);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateCustomerForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerType", customerTypeList);
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Customer customer, @PageableDefault(value = 5) Pageable pageable) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        Page<Customer> customerPage = customerService.findAll(pageable);
        modelAndView.addObject("customer", customerPage);
        modelAndView.addObject("message", "Add Completed!");
        return modelAndView;
    }

}
