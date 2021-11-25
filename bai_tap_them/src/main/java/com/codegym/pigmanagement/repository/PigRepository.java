package com.codegym.pigmanagement.repository;

import com.codegym.pigmanagement.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PigRepository extends JpaRepository<Pig, Long> {
    @Query(value = "SELECT * FROM pig WHERE pig_code LIKE :code AND status LIKE :status AND country_id LIKE :country ", nativeQuery = true)
    Page<Pig> search(Pageable pageable, String code, String status, String country);

    @Query(value ="SELECT * FROM pig WHERE status = 0 ORDER BY export_kg DESC LIMIT 0, 3", nativeQuery = true)
    List<Pig> getTop();
}
