package com.codegym.furamaresortcasestudy.service.imp;

import com.codegym.furamaresortcasestudy.model.AttachService;
import com.codegym.furamaresortcasestudy.repository.IAttachServiceRepository;
import com.codegym.furamaresortcasestudy.service.IAttachService;
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
