package com.ecom.demo.config;

import com.ecom.demo.model.Category;
import com.ecom.demo.model.Product;
import com.ecom.demo.repository.CategoryRepository;
import com.ecom.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("dev") // Ensures this runs only in the "dev" profile
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        seedCategoriesAndProducts();
    }

    private void seedCategoriesAndProducts() {
        log.info("========== Starting Data Seeding ==============");

        // Check if data already exists
        if (categoryRepository.count() > 0 || productRepository.count() > 0) {
            log.info("Data already exists. Skipping seeding.");
            return;
        }

        // log.info("Deleting existing Categories and Products...");
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        

        log.info("Seeding initial data...");

        // Create categories
        List<Category> categories = List.of(
                Category.builder().name("Electronics").build(),
                Category.builder().name("Fashion").build(),
                Category.builder().name("Home Appliances").build(),
                Category.builder().name("Books").build(),
                Category.builder().name("Sports").build(),
                Category.builder().name("Beauty").build(),
                Category.builder().name("Toys").build(),
                Category.builder().name("Automotive").build(),
                Category.builder().name("Health").build(),
                Category.builder().name("Groceries").build()
        );

        // Save categories
        categoryRepository.saveAll(categories);
        log.info("Number of Categories seeded: {}", categoryRepository.count());

        // Create products
        List<Product> products = List.of(
                Product.builder()
                        .name("Laptop")
                        .description("High-performance laptop for work and gaming")
                        .price(1299.99)
                        .imageUrl("https://placehold.co/600x400")
                        .category(categories.get(0)) // Electronics
                        .build(),
                        
                Product.builder()
                        .name("T-Shirt")
                        .description("Comfortable cotton t-shirt")
                        .price(19.99)
                        .imageUrl("https://placehold.co/600x400")
                        .category(categories.get(1)) // Fashion
                        .build(),
                Product.builder()
                        .name("Microwave Oven")
                        .description("Compact microwave oven for quick cooking")
                        .price(89.99)
                        .imageUrl("https://placehold.co/600x400")
                        .category(categories.get(2)) // Home Appliances
                        .build(),
                Product.builder()
                        .name("Java Programming Book")
                        .description("Comprehensive guide to Java programming")
                        .price(29.99)
                        .imageUrl("https://placehold.co/600x400")
                        .category(categories.get(3)) // Books
                        .build(),
                
                Product.builder()
                        .name("Soccer Ball")
                        .description("Official size soccer ball for training and matches")
                        .price(24.99)
                        .imageUrl("https://placehold.co/600x400")
                        .category(categories.get(2)) // Sports
                        .build(),
                Product.builder()
                        .name("Lipstick")
                        .description("Long-lasting lipstick in various shades")
                        .price(14.99)
                        .imageUrl("https://placehold.co/600x400")
                        .category(categories.get(1)) // Beauty
                        .build()
        );

        // Save products
        productRepository.saveAll(products);
        log.info("Number of Products seeded: {}", productRepository.count());

        log.info("======================== Data Seeding Completed ===========================");

        
    }
}
