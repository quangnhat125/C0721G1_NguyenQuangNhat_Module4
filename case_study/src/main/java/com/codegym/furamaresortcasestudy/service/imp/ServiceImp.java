package com.codegym.furamaresortcasestudy.service.imp;

import com.codegym.furamaresortcasestudy.model.Service;
import com.codegym.furamaresortcasestudy.repository.IServiceRepository;
import com.codegym.furamaresortcasestudy.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
@org.springframework.stereotype.Service
public class ServiceImp implements IService {
    @Autowired
    IServiceRepository serviceRepository;
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void update(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).get();
    }
}
