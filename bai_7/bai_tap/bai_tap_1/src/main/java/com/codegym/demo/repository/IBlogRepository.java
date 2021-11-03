package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.util.resources.ga.LocaleNames_ga;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
}
