package com.codegym.furamaresortcasestudy.controller;

import com.codegym.furamaresortcasestudy.dto.CustomerDto;
import com.codegym.furamaresortcasestudy.dto.ServiceDto;
import com.codegym.furamaresortcasestudy.model.*;
import com.codegym.furamaresortcasestudy.repository.IRentTypeRepository;
import com.codegym.furamaresortcasestudy.repository.IServiceRepository;
import com.codegym.furamaresortcasestudy.repository.IServiceTypeRepository;
import com.codegym.furamaresortcasestudy.service.IService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IService iService;
    @Autowired
    IServiceRepository serviceRepository;
    @Autowired
    IServiceTypeRepository serviceTypeRepository;
    @Autowired
    IRentTypeRepository rentTypeRepository;
    @ModelAttribute("rentTypeList")
    public List<RentType> getRentType() {
        return rentTypeRepository.findAll();
    }
    @ModelAttribute("serviceTypeList")
    public List<ServiceType> getServiceType() {
        return serviceTypeRepository.findAll();
    }

    @GetMapping("")
    public ModelAndView showListService(@PageableDefault(value = 5)Pageable pageable){
        Page<Service> servicePage = iService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/service/index");
        modelAndView.addObject("service", servicePage);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateServiceForm() {
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("serviceDto", new ServiceDto());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute @Validated ServiceDto serviceDto, BindingResult bindingResult) {
        new ServiceDto().validate(serviceDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/service/create");
        if (!bindingResult.hasFieldErrors()) {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            iService.save(service);
            modelAndView.addObject("message", "Add Completed!");
        }
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id, @PageableDefault(value = 5) Pageable pageable) {
        iService.deleteService(id);
        Page<Service> servicePage = iService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/service/index");
        modelAndView.addObject("service", servicePage);
        modelAndView.addObject("message", "Deleted Completed!");
        return modelAndView;
    }
}
