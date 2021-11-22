package com.codegym.furamaresortcasestudy.service;

import com.codegym.furamaresortcasestudy.model.ContractDetail;
import com.codegym.furamaresortcasestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);
    void deleteContractDetail(Long id);
    void save(ContractDetail contractDetail);
    void update(ContractDetail contractDetail);
    ContractDetail findById(Long id);
}
