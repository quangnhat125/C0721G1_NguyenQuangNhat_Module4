package com.codegym.demo.service;

import com.codegym.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void delete(Long id);
    void save(Product product);
    void update(Product product);
    Product findById(Long id);

    List<Product> search(String id, String productName, String price, String description, String producer, String category, int page, int sizePage);
}
