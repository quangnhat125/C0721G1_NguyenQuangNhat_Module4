package com.codegym.furamaresortcasestudy.service;

import com.codegym.furamaresortcasestudy.model.Customer;
import com.codegym.furamaresortcasestudy.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    void deleteCustomer(Long id);
    void save(Customer customer);
    void update(Customer customer);
    Customer findById(Long id);
    Page<Customer> search(Pageable pageable, String name, String gender, String typeCustomer);
}
