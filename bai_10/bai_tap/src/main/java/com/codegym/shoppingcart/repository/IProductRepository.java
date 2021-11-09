package com.codegym.shoppingcart.repository;

import com.codegym.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository  extends JpaRepository<Product, Long> {
}
