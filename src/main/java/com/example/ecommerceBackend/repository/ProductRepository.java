package com.example.ecommerceBackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerceBackend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Product> findByCategoryName(String categoryName, Pageable pageable); // To search by category
}
