package com.codegym.springsecurity.repository;

import com.codegym.springsecurity.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
