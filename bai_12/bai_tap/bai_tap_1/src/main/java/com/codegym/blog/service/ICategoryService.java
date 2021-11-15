package com.codegym.blog.service;

import com.codegym.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void deleteCategory(Long id);
    void update(Category category);
    void save(Category category);
    Category findById(Long id);
}
