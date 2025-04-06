package com.ecom.demo.dto;

import com.ecom.demo.model.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String name;

    // convert Entity to DTO
    public static CategoryDto fromEntity(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
    // convert DTO to Entity
    public static Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
    }
    
}
