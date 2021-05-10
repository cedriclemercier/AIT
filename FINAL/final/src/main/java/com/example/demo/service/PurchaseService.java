package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface PurchaseService {
    void save(Product product);
    Product findById(int id);
    List<Product> findAll();
}
