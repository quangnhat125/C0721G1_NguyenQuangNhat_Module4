package com.codegym.pigmanagement.service;

import com.codegym.pigmanagement.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPigService {
    List<Pig> findAll();
    Page<Pig> findAll(Pageable pageable);
    void deletePig(Long id);
    void update(Pig pig);
    void save(Pig pig);
    Pig findById(Long id);
    Page<Pig> search(Pageable pageable, String code, String status, String country);

    List<Pig> getTop();
}
