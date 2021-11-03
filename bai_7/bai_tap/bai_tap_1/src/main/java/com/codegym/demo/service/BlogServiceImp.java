package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImp implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void deleteBlog(Long id) {
        iBlogRepository.deleteById(id);

    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);

    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).get();
    }
}
