package com.example.ecommerceBackend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.ecommerceBackend.model.Product;

public interface ProductService {
    Page<Product> findByName(String name, Pageable pageable);
    Page<Product> findByCategory(String categoryName, Pageable pageable);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Product findById(Long id);
}
