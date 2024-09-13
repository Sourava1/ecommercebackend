package com.example.ecommerceBackend.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceBackend.model.Cart;
import com.example.ecommerceBackend.repository.CartRepository;
import com.example.ecommerceBackend.services.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart findByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
