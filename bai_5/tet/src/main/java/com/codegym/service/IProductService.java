package com.codegym.service;


import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> search(String productName);
}
