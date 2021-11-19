package com.codegym.furamaresortcasestudy.controller;

import com.codegym.furamaresortcasestudy.model.*;
import com.codegym.furamaresortcasestudy.service.IDivisionService;
import com.codegym.furamaresortcasestudy.service.IEducationService;
import com.codegym.furamaresortcasestudy.service.IEmployeeService;
import com.codegym.furamaresortcasestudy.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
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
        List<Position> positionList = positionService.findAll();
        List<Education> educationList = educationService.findAll();
        List<Division> divisionList = divisionService.findAll();
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("positionList", positionList);
        modelAndView.addObject("educationList", educationList);
        modelAndView.addObject("divisionList", divisionList);
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Employee employee, @PageableDefault(value = 5) Pageable pageable){
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/index");
        Page<Employee> employeePage = employeeService.findAll(pageable);
        modelAndView.addObject("employeeList", employeePage);
        modelAndView.addObject("message", "Add Completed!");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        List<Employee> employeeList = employeeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/index");
        modelAndView.addObject("employee", employeeList);
        modelAndView.addObject("message", "Deleted Completed!");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        List<Position> positionList = positionService.findAll();
        List<Education> educationList = educationService.findAll();
        List<Division> divisionList = divisionService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("position", positionList);
        modelAndView.addObject("education", educationList);
        modelAndView.addObject("division", divisionList);
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Employee employee) {
        employeeService.update(employee);
        List<Employee> employeeList = employeeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/index");
        modelAndView.addObject("employee", employeeList);
        modelAndView.addObject("message", "Update Completed!");
        return modelAndView;
    }


}
