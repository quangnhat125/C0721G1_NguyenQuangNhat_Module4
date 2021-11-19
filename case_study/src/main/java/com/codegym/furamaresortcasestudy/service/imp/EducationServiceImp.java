package com.codegym.furamaresortcasestudy.service.imp;

import com.codegym.furamaresortcasestudy.model.Education;
import com.codegym.furamaresortcasestudy.repository.IEducationRepository;
import com.codegym.furamaresortcasestudy.service.IEducationService;
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
