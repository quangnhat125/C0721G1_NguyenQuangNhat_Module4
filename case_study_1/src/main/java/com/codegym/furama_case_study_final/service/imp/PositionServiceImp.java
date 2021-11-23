package com.codegym.furama_case_study_final.service.imp;

import com.codegym.furama_case_study_final.model.Position;
import com.codegym.furama_case_study_final.repository.IPositionRepository;
import com.codegym.furama_case_study_final.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImp implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
