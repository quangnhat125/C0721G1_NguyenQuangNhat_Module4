package com.codegym.furama_case_study_final.service;

import com.codegym.furama_case_study_final.model.Customer;
import com.codegym.furama_case_study_final.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService {
    List<Service> findAll();
    Page<Service> findAll(Pageable pageable);
    void deleteService(Long id);
    void save(Service service);
    void update(Service service);
    Service findById(Long id);
}
