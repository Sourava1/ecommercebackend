package com.example.ecommerceBackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerceBackend.model.Inventory;
import com.example.ecommerceBackend.model.Order;
import com.example.ecommerceBackend.repository.InventoryRepository;
import com.example.ecommerceBackend.repository.OrderRepository;
import com.example.ecommerceBackend.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void placeOrder(Long productId, int quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory != null && inventory.getQuantity() >= quantity) {
            inventory.setQuantity(inventory.getQuantity() - quantity);
            inventoryRepository.save(inventory);
        } else {
            throw new RuntimeException("Insufficient stock");
        }
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
