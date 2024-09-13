package com.example.ecommerceBackend.services;

import com.example.ecommerceBackend.model.CartItem;

public interface CartItemService {
    CartItem findByCartIdAndProductId(Long cartId, Long productId);
    CartItem saveCartItem(CartItem cartItem);
    void deleteCartItem(Long id);
    void updateCartItemQuantity(Long cartId, Long productId, int quantity);
}