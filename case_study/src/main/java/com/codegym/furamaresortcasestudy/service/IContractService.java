package com.codegym.furamaresortcasestudy.service;

import com.codegym.furamaresortcasestudy.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    List<Contract> findAll();
    void deleteContract(Long id);

    void update(Contract contract);
    void save(Contract contract);
    Contract findById(Long id);
}
