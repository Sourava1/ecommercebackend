package com.example.ecommerceBackend.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceBackend.model.CartItem;
import com.example.ecommerceBackend.repository.CartItemRepository;
import com.example.ecommerceBackend.services.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem findByCartIdAndProductId(Long cartId, Long productId) {
        return cartItemRepository.findByCartIdAndProductId(cartId, productId);
    }

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public void updateCartItemQuantity(Long cartId, Long productId, int quantity) {
        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cartId, productId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
    }
}
