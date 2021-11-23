package com.codegym.furama_case_study_final.controller;

import com.codegym.furama_case_study_final.dto.ContractDto;
import com.codegym.furama_case_study_final.dto.ServiceDto;
import com.codegym.furama_case_study_final.model.*;
import com.codegym.furama_case_study_final.service.*;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractDetailService contractDetailService;
    @Autowired
    IAttachService attachService;
    @Autowired
    IContractService contractService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IService service;

    @ModelAttribute("contractList")
    public List<Contract> getContractList() {
        return contractService.findAll();
    }

    @ModelAttribute("attachService")
    public List<AttachService> getAttachService() {
        return attachService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<Employee> getEmployeeList() {
        return employeeService.findAll();
    }

    @ModelAttribute("customerList")
    public List<Customer> getCustomerList() {
        return customerService.findAll();
    }

    @ModelAttribute("serviceList")
    public List<Service> getServiceList() {
        return service.findAll();
    }

    @GetMapping("")
    public ModelAndView getListContract(@PageableDefault(value = 5) Pageable pageable) {
        Page<Contract> contractPage = contractService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/contract/index");
        modelAndView.addObject("contract", contractPage);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contractDto", new ContractDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult) {
        Service service1 = service.findById(contractDto.getService().getId());
        contractDto.setTotalMoney(service1.getServiceCost()) ;
        new ContractDto().validate(contractDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        if (!bindingResult.hasFieldErrors()) {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            modelAndView.addObject("message", "Add Completed!");
        }
        return modelAndView;
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("/contract/edit");
//        modelAndView.addObject("contract", contractService.findById(id));
//        return modelAndView;
//    }
//
//    @PostMapping("/update")
//    public ModelAndView update(@ModelAttribute Contract contract, @PageableDefault(value = 5) Pageable pageable) {
//        contractService.update(contract);
//        List<Contract> contractPage = contractService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/contract/index");
//        modelAndView.addObject("contract", contractPage);
//        modelAndView.addObject("message", "Update Completed!");
//        return modelAndView;
//    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id, @PageableDefault(value = 5) Pageable pageable) {
        contractService.deleteContract(id);
        Page<Contract> contractPage = contractService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/contract/index");
        modelAndView.addObject("contract", contractPage);
        modelAndView.addObject("message", "Deleted Completed!");
        return modelAndView;
    }
}
