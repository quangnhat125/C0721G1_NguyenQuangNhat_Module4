package com.codegym.blogmorong.controller;

import com.codegym.blogmorong.model.Category;
import com.codegym.blogmorong.repository.ICategoryRepository;
import com.codegym.blogmorong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category-api")
public class CategoryRestController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> listCategory(){
        List<Category> categoryList = categoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
