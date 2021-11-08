package com.codegym.furamaresortcasestudy.repository;

import com.codegym.furamaresortcasestudy.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
