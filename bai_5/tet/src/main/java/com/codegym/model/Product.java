package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private double productPrice;
    private String productCompany;

    public Product() {
    }

    public Product(String productName, double productPrice, String productCompany) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCompany = productCompany;
    }

    public Product(int id, String productName, double productPrice, String productCompany) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCompany = productCompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }
}
