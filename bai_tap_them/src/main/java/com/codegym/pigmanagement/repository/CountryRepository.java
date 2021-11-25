package com.codegym.pigmanagement.repository;

import com.codegym.pigmanagement.model.OriginCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<OriginCountry, Long> {
}
