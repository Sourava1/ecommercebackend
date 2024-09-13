package com.example.ecommerceBackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceBackend.model.OrderItem;
import com.example.ecommerceBackend.repository.OrderItemRepository;
import com.example.ecommerceBackend.services.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
    
    @Override
    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderItem not found"));
    }
}
