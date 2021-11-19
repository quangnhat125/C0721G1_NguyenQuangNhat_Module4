package com.codegym.furamaresortcasestudy.service;

import com.codegym.furamaresortcasestudy.model.Customer;
import com.codegym.furamaresortcasestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    void deleteEmployee(Long id);
    void save(Employee employee);
    void update(Employee employee);
    Employee findById(Long id);
}
