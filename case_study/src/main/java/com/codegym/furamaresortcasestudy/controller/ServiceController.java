package com.codegym.furamaresortcasestudy.controller;

import com.codegym.furamaresortcasestudy.dto.CustomerDto;
import com.codegym.furamaresortcasestudy.model.CustomerType;
import com.codegym.furamaresortcasestudy.model.RentType;
import com.codegym.furamaresortcasestudy.model.Service;
import com.codegym.furamaresortcasestudy.model.ServiceType;
import com.codegym.furamaresortcasestudy.repository.IRentTypeRepository;
import com.codegym.furamaresortcasestudy.repository.IServiceRepository;
import com.codegym.furamaresortcasestudy.repository.IServiceTypeRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IServiceRepository serviceRepository;
    @Autowired
    IServiceTypeRepository serviceTypeRepository;
    @Autowired
    IRentTypeRepository rentTypeRepository;

    @GetMapping("")
    public ModelAndView showListService(@PageableDefault(value = 5)Pageable pageable){
        Page<Service> servicePage = serviceRepository.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/service/index");
        modelAndView.addObject("service", servicePage);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateServiceForm() {
        ModelAndView modelAndView = new ModelAndView("/service/create");
        List<ServiceType> serviceTypeList = serviceTypeRepository.findAll();
        List<Service> serviceList = serviceRepository.findAll();
        List<RentType> rentTypeList = rentTypeRepository.findAll();
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("rentTypeList", rentTypeList);
        modelAndView.addObject("serviceTypeList", serviceTypeList);
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Service service, @PageableDefault(value = 5) Pageable pageable) {
        serviceRepository.save(service);
        ModelAndView modelAndView = new ModelAndView("/service/index");
        Page<Service> servicePage = serviceRepository.findAll(pageable);
        modelAndView.addObject("serviceList", servicePage);
        modelAndView.addObject("message", "Add Completed!");
        return modelAndView;
    }
}