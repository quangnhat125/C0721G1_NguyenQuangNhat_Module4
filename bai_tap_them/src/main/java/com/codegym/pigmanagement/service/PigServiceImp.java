package com.codegym.pigmanagement.service;

import com.codegym.pigmanagement.model.Pig;
import com.codegym.pigmanagement.repository.PigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PigServiceImp implements IPigService{

    @Autowired
    PigRepository pigRepository;
    @Override
    public List<Pig> findAll() {
        return pigRepository.findAll();
    }

    @Override
    public Page<Pig> findAll(Pageable pageable) {
        return pigRepository.findAll(pageable);
    }

    @Override
    public void deletePig(Long id) {
        pigRepository.deleteById(id);
    }

    @Override
    public void update(Pig pig) {
        pigRepository.save(pig);

    }

    @Override
    public void save(Pig pig) {
        pigRepository.save(pig);

    }

    @Override
    public Pig findById(Long id) {
        return pigRepository.findById(id).get();
    }

    @Override
    public Page<Pig> search(Pageable pageable, String code, String status, String country) {
        return pigRepository.search(pageable, "%" +  code + "%", "%" + status + "%", "%" + country +  "%");
    }

    @Override
    public List<Pig> getTop() {
        return pigRepository.getTop();
    }
}
