package com.codegym.furamaresortcasestudy.controller;

import com.codegym.furamaresortcasestudy.dto.CustomerDto;
import com.codegym.furamaresortcasestudy.model.Customer;
import com.codegym.furamaresortcasestudy.model.CustomerType;
import com.codegym.furamaresortcasestudy.service.ICustomerService;
import com.codegym.furamaresortcasestudy.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.sql.Date;
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
    public ModelAndView showListCustomer(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customerPage = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customer", customerPage);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateCustomerForm() {
        CustomerDto customerDto = new CustomerDto();
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerDto", customerDto);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult) {
        List<Customer> customerList = customerService.findAll();
        customerDto.setCustomerList(customerList);
        new CustomerDto().validate(customerDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        if (!bindingResult.hasFieldErrors()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            modelAndView.addObject("message", "Add Completed!");
        }
        return modelAndView;

    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        modelAndView.addObject("customerDto", customerDto);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult) {
        List<Customer> customerList = customerService.findAll();
        customerDto.setCustomerList(customerList);
        new CustomerDto().validate(customerDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        if (!bindingResult.hasFieldErrors()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            modelAndView.addObject("message", "Edit Completed!");
        }
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id, @PageableDefault(value = 5) Pageable pageable) {
        customerService.deleteCustomer(id);
        Page<Customer> customerList = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customer", customerList);
        modelAndView.addObject("message", "Deleted Completed!");
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "customerNameSearch", defaultValue = "", required = false) String customerNameSearch,
                               @RequestParam(value = "genSearch", defaultValue = "", required = false) String genSearch,
                               @RequestParam(value = "typeCustomer", defaultValue = "", required = false) String typeCustomer,
                               @PageableDefault(value = 5, sort = "customerCode", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        Page<Customer> customerPage = customerService.search(pageable, customerNameSearch, genSearch, typeCustomer);
        modelAndView.addObject("name", customerNameSearch);
        modelAndView.addObject("gender", genSearch);
        modelAndView.addObject("typeCustomer", typeCustomer);
        modelAndView.addObject("customer", customerPage);
        return modelAndView;
    }

}
