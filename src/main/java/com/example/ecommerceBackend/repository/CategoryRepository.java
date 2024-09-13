package com.example.ecommerceBackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerceBackend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name); // Find a category by its name
}

