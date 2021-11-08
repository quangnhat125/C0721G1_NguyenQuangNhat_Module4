package com.codegym.furamaresortcasestudy.repository;

import com.codegym.furamaresortcasestudy.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
