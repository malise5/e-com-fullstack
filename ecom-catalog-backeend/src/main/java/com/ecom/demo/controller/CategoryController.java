package com.ecom.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.demo.dto.CategoryDto;
import com.ecom.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    private final CategoryService categoryService;
    
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.status(200)
                .body(categoryService.getAllCategories());
    }
}
