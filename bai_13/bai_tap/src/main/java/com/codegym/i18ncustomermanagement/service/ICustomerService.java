package com.codegym.i18ncustomermanagement.service;

import com.codegym.i18ncustomermanagement.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
