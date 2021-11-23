package com.codegym.furama_case_study_final.service.imp;

import com.codegym.furama_case_study_final.model.Contract;
import com.codegym.furama_case_study_final.repository.IContractRepository;
import com.codegym.furama_case_study_final.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImp implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.deleteById(id);

    }

    @Override
    public void update(Contract contract) {
        contractRepository.save(contract);

    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).get();
    }
}
