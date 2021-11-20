package com.codegym.demo.repository;

import ch.qos.logback.core.boolex.EvaluationException;
import com.codegym.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value ="SELECT * FROM product WHERE id LIKE :id AND product_name LIKE :name AND price LIKE :price " +
            "AND description LIKE :des AND producer LIKE :producer AND category_id LIKE :cate LIMIT :page, :sizePage", nativeQuery = true)
    List<Product> search(String id, String name, String price, String des, String producer, String cate, int page, int sizePage);
}
