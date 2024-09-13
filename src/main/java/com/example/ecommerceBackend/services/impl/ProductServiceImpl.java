package com.example.ecommerceBackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ecommerceBackend.model.Product;
import com.example.ecommerceBackend.repository.ProductRepository;
import com.example.ecommerceBackend.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Page<Product> findByCategory(String categoryName, Pageable pageable) {
        return productRepository.findByCategoryName(categoryName, pageable);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
