package com.codegym.springsecurity.service.imp;

import com.codegym.springsecurity.model.Category;
import com.codegym.springsecurity.repository.ICategoryRepository;
import com.codegym.springsecurity.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findById(id).get();
    }
}
