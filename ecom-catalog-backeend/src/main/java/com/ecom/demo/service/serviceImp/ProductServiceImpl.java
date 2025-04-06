package com.ecom.demo.service.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.demo.custom.ProductNotFoundException;
import com.ecom.demo.dto.ProductDto;
import com.ecom.demo.repository.ProductRepository;
import com.ecom.demo.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {

        List<ProductDto> products = productRepository.findAll()
                .stream()
                .map(prod -> ProductDto.toDto(prod))
                .toList();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found");

        }
        log.info("Successfully retrieved {} products", products.size());
        return products;

    }

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {

        List<ProductDto> products = productRepository.findByCategoryId(categoryId)
                .stream()
                .map(prod -> ProductDto.toDto(prod))
                .toList();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found for category ID: " + categoryId);
        }
        log.info("Successfully retrieved {} products for category ID: {}", products.size(), categoryId);
        return products;

    }

}
