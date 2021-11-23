package com.codegym.furama_case_study_final.service.imp;

import com.codegym.furama_case_study_final.model.Employee;
import com.codegym.furama_case_study_final.repository.IEmployeeRepository;
import com.codegym.furama_case_study_final.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Page<Employee> search(Pageable pageable, String name, String address, String typePosition, String typeEducation, String typeDivision) {
        return employeeRepository.search(pageable, "%" + name +"%", "%" + address + "%", "%" + typePosition +"%", "%" + typeEducation + "%", "%" + typeDivision +"%");
    }
}
