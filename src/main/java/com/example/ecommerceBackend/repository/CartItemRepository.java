package com.example.ecommerceBackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerceBackend.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndProductId(Long cartId, Long productId);  // Find specific item in a user's cart
}
