package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findById(int id);
}
