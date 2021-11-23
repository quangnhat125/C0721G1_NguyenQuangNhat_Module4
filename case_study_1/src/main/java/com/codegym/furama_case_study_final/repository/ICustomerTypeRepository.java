package com.codegym.furama_case_study_final.repository;

import com.codegym.furama_case_study_final.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
