package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    void deleteBlog(Long id);

    void update(Blog blog);

    void save(Blog blog);

    Blog findById(Long id);

    Page<Blog> searchAll(Pageable pageable, String searchTitle,
                         String idCategory);
}
