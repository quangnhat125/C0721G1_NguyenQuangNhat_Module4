package com.codegym.springsecurity.service.imp;

import com.codegym.springsecurity.model.Blog;
import com.codegym.springsecurity.repository.IBlogRepository;
import com.codegym.springsecurity.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
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

    @Override
    public Page<Blog> searchAll(Pageable pageable, String searchTitle, String idCategory) {
        return iBlogRepository.searchAll(pageable, "%" + searchTitle + "%", "%" + idCategory + "%");
    }
}
