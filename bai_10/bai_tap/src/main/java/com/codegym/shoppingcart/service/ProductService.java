package com.codegym.shoppingcart.service;

import com.codegym.shoppingcart.model.Product;
import com.codegym.shoppingcart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findId(Long id) {
        return productRepository.findById(id).get();
    }
}
