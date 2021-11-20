package com.codegym.demo.service;


import com.codegym.demo.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICategoryService {
    List<Category> findAll();

    Category findById(Long id);
}
