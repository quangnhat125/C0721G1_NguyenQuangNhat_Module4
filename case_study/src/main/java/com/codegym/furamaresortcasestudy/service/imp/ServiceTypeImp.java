package com.codegym.furamaresortcasestudy.service.imp;

import com.codegym.furamaresortcasestudy.model.ServiceType;
import com.codegym.furamaresortcasestudy.repository.IServiceTypeRepository;
import com.codegym.furamaresortcasestudy.service.IServiceType;
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
