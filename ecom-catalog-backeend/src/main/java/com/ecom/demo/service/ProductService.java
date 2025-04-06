package com.ecom.demo.service;

import java.util.List;

import com.ecom.demo.dto.ProductDto;

public interface ProductService {
    
    List<ProductDto> getAllProducts();
    List<ProductDto> getProductsByCategoryId(Long categoryId);
    
}
