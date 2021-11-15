package com.codegym.i18ncustomermanagement.repository;

import com.codegym.i18ncustomermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
