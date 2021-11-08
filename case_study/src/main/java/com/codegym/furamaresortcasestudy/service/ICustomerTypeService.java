package com.codegym.furamaresortcasestudy.service;

import com.codegym.furamaresortcasestudy.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
    void deleteCustomerType(Long id);
    void save(CustomerType customerType);
    void update(CustomerType customerType);
    CustomerType findById(Long id);
}
