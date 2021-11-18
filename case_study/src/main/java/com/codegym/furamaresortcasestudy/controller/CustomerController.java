package com.codegym.furamaresortcasestudy.controller;

import com.codegym.furamaresortcasestudy.dto.CustomerDto;
import com.codegym.furamaresortcasestudy.model.Customer;
import com.codegym.furamaresortcasestudy.model.CustomerType;
import com.codegym.furamaresortcasestudy.service.ICustomerService;
import com.codegym.furamaresortcasestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
        CustomerDto customerDto = new CustomerDto();
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        modelAndView.addObject("customer", customerDto);
        modelAndView.addObject("customerType", customerTypeList);
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        List<Customer> customerList = customerService.findAll();
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        } else{
            Customer customer = new Customer();
            customerService.save(customer);
            modelAndView.addObject("customer", customerDto);
            modelAndView.addObject("success", "Create customer successfully !");
        }
        return modelAndView;

    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        List<CustomerType> customerType = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customerType", customerType);
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Customer customer) {
        customerService.update(customer);
        List<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customer", customerList);
        modelAndView.addObject("message", "Update Completed!");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        List<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customer", customerList);
        modelAndView.addObject("message", "Deleted Completed!");
        return modelAndView;
    }


}
