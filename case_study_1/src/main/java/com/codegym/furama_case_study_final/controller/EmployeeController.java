package com.codegym.furama_case_study_final.controller;

import com.codegym.furama_case_study_final.dto.CustomerDto;
import com.codegym.furama_case_study_final.dto.EmployeeDto;
import com.codegym.furama_case_study_final.model.*;
import com.codegym.furama_case_study_final.service.IDivisionService;
import com.codegym.furama_case_study_final.service.IEducationService;
import com.codegym.furama_case_study_final.service.IEmployeeService;
import com.codegym.furama_case_study_final.service.IPositionService;
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
    public ModelAndView delete(@RequestParam Long id, @PageableDefault(value = 5) Pageable pageable) {
        employeeService.deleteEmployee(id);
        Page<Employee> employeeList = employeeService.findAll(pageable);
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
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "employeeNameSearch", defaultValue = "", required = false) String employeeNameSearch,
                               @RequestParam(value = "addressSearch", defaultValue = "", required = false) String addressSearch,
                               @RequestParam(value = "typePosition", defaultValue = "", required = false) String typePosition,
                               @RequestParam(value = "typeEducation", defaultValue = "", required = false) String typeEducation,
                               @RequestParam(value = "typeDivision", defaultValue = "", required = false) String typeDivision,
                               @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/index");
        Page<Employee> employeePage = employeeService.search(pageable, employeeNameSearch, addressSearch, typePosition, typeEducation, typeDivision);
        modelAndView.addObject("name", employeeNameSearch);
        modelAndView.addObject("addressSearch", addressSearch);
        modelAndView.addObject("typePosition", typePosition);
        modelAndView.addObject("typeEducation", typeEducation);
        modelAndView.addObject("typeDivision", typeDivision);
        modelAndView.addObject("employee", employeePage);
        return modelAndView;
    }


}
