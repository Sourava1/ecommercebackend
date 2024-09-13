package com.example.ecommerceBackend.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceBackend.model.Category;
import com.example.ecommerceBackend.repository.CategoryRepository;
import com.example.ecommerceBackend.services.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
