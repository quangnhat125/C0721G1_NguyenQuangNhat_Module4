package com.codegym.furama_case_study_final.service.imp;
import com.codegym.furama_case_study_final.model.Education;
import com.codegym.furama_case_study_final.repository.IEducationRepository;
import com.codegym.furama_case_study_final.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationServiceImp implements IEducationService {
    @Autowired
    IEducationRepository educationRepository;
    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
}
