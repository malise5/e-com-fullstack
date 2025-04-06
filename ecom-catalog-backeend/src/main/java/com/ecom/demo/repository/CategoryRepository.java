package com.ecom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom query methods can be defined here if needed
    // For example, find categories by name, etc.
    
}
