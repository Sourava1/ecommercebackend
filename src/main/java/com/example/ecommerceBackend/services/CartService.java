package com.example.ecommerceBackend.services;

import com.example.ecommerceBackend.model.Cart;

public interface CartService {
    Cart findByUserId(Long userId);
    Cart saveCart(Cart cart);
    void deleteCart(Long id);
}