package com.codegym.furamaresortcasestudy.controller;

import com.codegym.furamaresortcasestudy.dto.CustomerDto;
import com.codegym.furamaresortcasestudy.dto.EmployeeDto;
import com.codegym.furamaresortcasestudy.model.*;
import com.codegym.furamaresortcasestudy.service.IDivisionService;
import com.codegym.furamaresortcasestudy.service.IEducationService;
import com.codegym.furamaresortcasestudy.service.IEmployeeService;
import com.codegym.furamaresortcasestudy.service.IPositionService;
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

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationService educationService;
    @ModelAttribute("positionList")
    public List<Position> getPositionList(){
        return positionService.findAll();
    }
    @ModelAttribute("educationList")
    public List<Education> getEducationList(){
        return educationService.findAll();
    }
    @ModelAttribute("divisionList")
    public List<Division> getDivisionList(){
        return divisionService.findAll();
    }


    @GetMapping("")
    public ModelAndView showListEmployee(@PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employeePage = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/index");
        modelAndView.addObject("employee", employeePage);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult){
        List<Employee> employeeList = employeeService.findAll();
        employeeDto.setEmployeeList(employeeList);
        new EmployeeDto().validate(employeeDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        if (!bindingResult.hasFieldErrors()) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            modelAndView.addObject("message", "Add Completed!");
        }
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        List<Employee> employeeList = employeeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/index");
        modelAndView.addObject("employee", employeeList);
        modelAndView.addObject("message", "Deleted Completed!");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employee", employeeService.findById(id));
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        modelAndView.addObject("employeeDto", employeeDto);
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult) {
        List<Employee> customerList = employeeService.findAll();
        employeeDto.setEmployeeList(customerList);
        new EmployeeDto().validate(employeeDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        if (!bindingResult.hasFieldErrors()) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            modelAndView.addObject("message", "Edit Completed!");
        }
        return modelAndView;
    }


}
