package com.codegym.furama_case_study_final.service;

import com.codegym.furama_case_study_final.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
    void deleteCustomerType(Long id);
    void save(CustomerType customerType);
    void update(CustomerType customerType);
    CustomerType findById(Long id);
}
