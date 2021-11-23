package com.codegym.furama_case_study_final.repository;

import com.codegym.furama_case_study_final.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Long> {
}
