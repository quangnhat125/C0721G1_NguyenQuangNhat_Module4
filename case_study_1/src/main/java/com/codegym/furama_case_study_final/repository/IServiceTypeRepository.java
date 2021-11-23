package com.codegym.furama_case_study_final.repository;

import com.codegym.furama_case_study_final.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
