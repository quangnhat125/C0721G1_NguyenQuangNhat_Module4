package com.codegym.furama_case_study_final.repository;

import com.codegym.furama_case_study_final.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Long> {
}
