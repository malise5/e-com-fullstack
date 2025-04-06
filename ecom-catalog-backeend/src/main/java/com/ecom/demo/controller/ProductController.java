package com.ecom.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.demo.dto.ProductDto;
import com.ecom.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    // Define endpoints for product-related operations
    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable Long categoryId) {
        List<ProductDto> products = productService.getProductsByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }
    
}
