package com.codegym.furama_case_study_final.service.imp;
import com.codegym.furama_case_study_final.model.ContractDetail;
import com.codegym.furama_case_study_final.repository.IContractDetailRepository;
import com.codegym.furama_case_study_final.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImp implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public void deleteContractDetail(Long id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void update(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.findById(id).get();
    }
}
