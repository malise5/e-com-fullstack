package com.ecom.demo.service;

import java.util.List;

import com.ecom.demo.dto.CategoryDto;

public interface CategoryService {
    
    List<CategoryDto> getAllCategories();


    // Example method signatures:
    // Category createCategory(Category category);
    // Category getCategoryById(Long id);
    // Category updateCategory(Long id, Category category);
    // void deleteCategory(Long id);
   
    // List<Category> getCategoriesByProductId(Long productId);
    // List<Category> getCategoriesByName(String name);
    // List<Category> getCategoriesByParentId(Long parentId);
    // List<Category> getCategoriesByProductName(String productName);
}
