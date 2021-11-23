package com.codegym.furama_case_study_final.service.imp;

import com.codegym.furama_case_study_final.model.AttachService;
import com.codegym.furama_case_study_final.repository.IAttachServiceRepository;
import com.codegym.furama_case_study_final.service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceImp implements IAttachService {

    @Autowired
    IAttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
