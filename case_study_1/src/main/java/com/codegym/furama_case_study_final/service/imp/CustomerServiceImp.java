package com.codegym.furama_case_study_final.service.imp;

import com.codegym.furama_case_study_final.dto.CustomerDetail;
import com.codegym.furama_case_study_final.dto.CustomerInUsing;
import com.codegym.furama_case_study_final.model.Customer;
import com.codegym.furama_case_study_final.repository.ICustomerRepository;
import com.codegym.furama_case_study_final.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImp implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);

    }
    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> search(Pageable pageable, String name, String gender, String typeCustomer) {
        return customerRepository.search(pageable, "%" + name +"%", "%" + gender +"%", "%" + typeCustomer +"%");
    }

    @Override
    public List<CustomerInUsing> showList(int page, int size) {
        return customerRepository.showList(page, size);
    }

    @Override
    public List<CustomerDetail> showListDetail(Long id) {
        return customerRepository.showListDetail(id);
    }
}
