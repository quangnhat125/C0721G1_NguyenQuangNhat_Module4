package com.codegym.furamaresortcasestudy.service.imp;

import com.codegym.furamaresortcasestudy.model.RentType;
import com.codegym.furamaresortcasestudy.repository.IRentTypeRepository;
import com.codegym.furamaresortcasestudy.service.IRentTypeService;
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
