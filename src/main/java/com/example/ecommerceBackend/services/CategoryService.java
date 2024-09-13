package com.example.ecommerceBackend.services;
import java.util.List;

import com.example.ecommerceBackend.model.Category;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findByName(String name);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
    Category findById(Long id);
}