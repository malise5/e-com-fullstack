package com.ecom.demo.dto;

import com.ecom.demo.model.Category;
import com.ecom.demo.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private CategoryDto category; // Reference to the category

    // convert Entity to Dto
    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .category(CategoryDto.builder()
                        .id(product.getCategory().getId())
                        .name(product.getCategory().getName())
                        .build()) // Set the category
                .build();
    }

    // convert Dto to Entity
    public static Product toEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .imageUrl(productDto.getImageUrl())
                .category(productDto.getCategory() != null ? CategoryDto.toEntity(productDto.getCategory()) : null)
                .build();
    }
}