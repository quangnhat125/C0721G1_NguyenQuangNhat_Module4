package com.codegym.furama_case_study_final.repository;

import com.codegym.furama_case_study_final.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository  extends JpaRepository<Education, Long> {
}
