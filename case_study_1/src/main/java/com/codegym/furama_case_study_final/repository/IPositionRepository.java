package com.codegym.furama_case_study_final.repository;

import com.codegym.furama_case_study_final.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Long> {
}
