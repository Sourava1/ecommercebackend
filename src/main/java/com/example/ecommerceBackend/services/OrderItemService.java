package com.example.ecommerceBackend.services;

import com.example.ecommerceBackend.model.OrderItem;

public interface OrderItemService {
    OrderItem saveOrderItem(OrderItem orderItem);
    void deleteOrderItem(Long id);
	OrderItem findById(Long id);
}
