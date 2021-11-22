package com.codegym.furamaresortcasestudy.controller;

import com.codegym.furamaresortcasestudy.dto.ContractDetailDto;
import com.codegym.furamaresortcasestudy.dto.EmployeeDto;
import com.codegym.furamaresortcasestudy.dto.ServiceDto;
import com.codegym.furamaresortcasestudy.model.*;
import com.codegym.furamaresortcasestudy.service.IAttachService;
import com.codegym.furamaresortcasestudy.service.IContractDetailService;
import com.codegym.furamaresortcasestudy.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    IContractDetailService contractDetailService;
    @Autowired
    IAttachService attachService;
    @Autowired
    IContractService contractService;

    @ModelAttribute("contractList")
    public List<Contract> getContractList() {
        return contractService.findAll();
    }

    @ModelAttribute("attachService")
    public List<AttachService> getAttachService() {
        return attachService.findAll();
    }

    @GetMapping("")
    public ModelAndView listContractDetail(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/contract_detail/index");
        Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
        modelAndView.addObject("contractDetailList", contractDetails);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/contract_detail/create");
        modelAndView.addObject("contractDetailDto", new ContractDetailDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute @Validated ContractDetailDto contractDetailDto, BindingResult bindingResult) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/contract_detail/create");
        if (!bindingResult.hasFieldErrors()) {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            modelAndView.addObject("message", "Add Completed!");
        }
        return modelAndView;
    }
}
