package com.codegym.furama_case_study_final.service.imp;

import com.codegym.furama_case_study_final.model.RentType;
import com.codegym.furama_case_study_final.repository.IRentTypeRepository;
import com.codegym.furama_case_study_final.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImp implements IRentTypeService {

    @Autowired
    IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
