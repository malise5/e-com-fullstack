package com.ecom.demo.service.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.demo.custom.CategoryNotFoundException;
import com.ecom.demo.dto.CategoryDto;
import com.ecom.demo.repository.CategoryRepository;
import com.ecom.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {

        List<CategoryDto> categories = categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .toList();
        if (categories.isEmpty()) {
            log.warn("No categories found");
            throw new CategoryNotFoundException("No categories found");
        }
        log.info("Successfully fetched {} categories", categories.size());
        return categories;

    }

}
