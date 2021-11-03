package com.codegym.demo.service;

import com.codegym.demo.model.Blog;


import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void deleteBlog(Long id);
    void update(Blog blog);
    void save(Blog blog);
    Blog findById(Long id);
}
