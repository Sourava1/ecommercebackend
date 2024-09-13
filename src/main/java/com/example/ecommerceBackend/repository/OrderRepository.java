package com.example.ecommerceBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerceBackend.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId); // Find all orders for a specific user
}
