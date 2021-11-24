package com.codegym.furama_case_study_final.controller;

import com.codegym.furama_case_study_final.dto.CustomerDetail;
import com.codegym.furama_case_study_final.dto.CustomerDto;
import com.codegym.furama_case_study_final.dto.CustomerInUsing;
import com.codegym.furama_case_study_final.model.Customer;
import com.codegym.furama_case_study_final.model.CustomerType;
import com.codegym.furama_case_study_final.service.ICustomerService;
import com.codegym.furama_case_study_final.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == customerDto.getId()) {
                customerList.remove(customerList.get(i));
            }
        }
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
                               @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        Page<Customer> customerPage = customerService.search(pageable, customerNameSearch, genSearch, typeCustomer);
        modelAndView.addObject("name", customerNameSearch);
        modelAndView.addObject("gender", genSearch);
        modelAndView.addObject("typeCustomer", typeCustomer);
        modelAndView.addObject("customer", customerPage);
        return modelAndView;
    }
    @GetMapping("/in-using")
    public ModelAndView showListInUsing(@RequestParam(value = "page", defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/customer/in_using");
        int size = 6;
        List<CustomerInUsing> customerInUsingList = customerService.showList(0, 9999);
        int total = customerInUsingList.size() + 1/ size;
        int newPage = page * size;
        List<CustomerInUsing> newCustomerInUsingList = customerService.showList(newPage, size);
        modelAndView.addObject("newCustomerList", newCustomerInUsingList);
        modelAndView.addObject("page", page);
        modelAndView.addObject("total", total );
        return modelAndView;
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        List<CustomerDetail> customerDetailList = customerService.showListDetail(id);
        return new ResponseEntity<>(customerDetailList, HttpStatus.OK);
    }


}
