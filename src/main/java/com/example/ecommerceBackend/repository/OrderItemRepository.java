package com.example.ecommerceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerceBackend.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
