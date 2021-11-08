package com.codegym.furamaresortcasestudy.service.imp;

import com.codegym.furamaresortcasestudy.model.CustomerType;
import com.codegym.furamaresortcasestudy.repository.ICustomerTypeRepository;
import com.codegym.furamaresortcasestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImp implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void deleteCustomerType(Long id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public void save(CustomerType customerType){
        customerTypeRepository.save(customerType);
    }

    @Override
    public void update(CustomerType customerType) {
        customerTypeRepository.save(customerType);

    }

    @Override
    public CustomerType findById(Long id) {
        return customerTypeRepository.findById(id).get();
    }
}
