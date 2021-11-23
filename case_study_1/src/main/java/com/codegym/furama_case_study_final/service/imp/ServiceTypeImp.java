package com.codegym.furama_case_study_final.service.imp;

import com.codegym.furama_case_study_final.model.ServiceType;
import com.codegym.furama_case_study_final.repository.IServiceTypeRepository;
import com.codegym.furama_case_study_final.service.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeImp implements IServiceType {

    @Autowired
    IServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
