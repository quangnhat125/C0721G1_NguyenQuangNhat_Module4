package com.codegym.pigmanagement.service;

import com.codegym.pigmanagement.model.OriginCountry;

import java.util.List;

public interface ICountryService {
    List<OriginCountry> findAll();
}
