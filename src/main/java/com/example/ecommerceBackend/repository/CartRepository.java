package com.example.ecommerceBackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecommerceBackend.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);  // Get the cart for a specific user
}

