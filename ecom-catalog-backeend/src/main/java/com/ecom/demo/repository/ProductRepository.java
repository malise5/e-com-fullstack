package com.ecom.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods can be defined here if needed
    // For example, find products by category, price range, etc.
    List<Product> findByCategoryId(Long categoryId);
    
}
