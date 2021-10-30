package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone12", 25000000, "New", "Apple"));
        products.put(2, new Product(2, "SamSung Galaxy Fold 3", 35000000, "New 95%", "SamSung"));
        products.put(3, new Product(3, "Iphone12 Pro Max", 28000000, "New 99%", "Apple"));
        products.put(4, new Product(4, "IphoneX", 15000000, "New", "Apple"));
        products.put(5, new Product(5, "Iphone7", 15000000, "New", "Apple"));
        products.put(6, new Product(6, "Iphone13", 35000000, "New", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        System.out.println(product.getProductName());
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(Product product) {
        return null;
    }
}
