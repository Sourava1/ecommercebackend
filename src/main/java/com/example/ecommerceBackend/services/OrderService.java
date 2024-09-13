package com.example.ecommerceBackend.services;

import java.util.List;

import com.example.ecommerceBackend.model.Order;

public interface OrderService {
    List<Order> findByUserId(Long userId);
    Order saveOrder(Order order);
    void deleteOrder(Long id);
    Order findById(Long id);
    void placeOrder(Long productId, int quantity); // Business logic for placing an order
}
