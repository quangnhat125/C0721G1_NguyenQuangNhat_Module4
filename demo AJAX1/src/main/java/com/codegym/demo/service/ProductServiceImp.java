package com.codegym.demo.service;

import com.codegym.demo.model.Product;
import com.codegym.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> search(String id, String productName, String price, String description, String producer, String category, int page, int sizePage) {
        return productRepository.search("%" + id +"%","%"+ productName +"%","%"+ price +"%","%"+ description +"%","%"+ producer +"%","%"+ category +"%", page, sizePage);
    }
}
