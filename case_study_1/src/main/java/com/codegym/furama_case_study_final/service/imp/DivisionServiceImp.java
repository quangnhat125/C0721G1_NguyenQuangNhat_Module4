package com.codegym.furama_case_study_final.service.imp;

import com.codegym.furama_case_study_final.model.Division;
import com.codegym.furama_case_study_final.repository.IDivisionRepository;
import com.codegym.furama_case_study_final.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImp implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
