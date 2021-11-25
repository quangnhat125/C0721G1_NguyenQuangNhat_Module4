package com.codegym.pigmanagement.service;

import com.codegym.pigmanagement.model.OriginCountry;
import com.codegym.pigmanagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImp implements ICountryService{
    @Autowired
    CountryRepository countryRepository;
    @Override
    public List<OriginCountry> findAll() {
        return countryRepository.findAll();
    }
}
