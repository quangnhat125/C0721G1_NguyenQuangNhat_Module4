package com.codegym.furama_case_study_final.repository;

import com.codegym.furama_case_study_final.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Long> {
}
