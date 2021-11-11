package com.codegym.blogmorong.repository;

import com.codegym.blogmorong.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
