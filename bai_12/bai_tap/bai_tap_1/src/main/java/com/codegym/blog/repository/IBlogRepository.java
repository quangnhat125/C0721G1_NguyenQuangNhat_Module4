package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT * FROM blog WHERE blog_title LIKE :searchTitle  AND category_id Like :idCategory ",
            nativeQuery = true)
    Page<Blog> searchAll(Pageable pageable, @Param("searchTitle") String searchTitle,
                         @Param("idCategory") String idCategory);
}
