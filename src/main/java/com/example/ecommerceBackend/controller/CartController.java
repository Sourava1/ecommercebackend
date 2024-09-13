package com.example.ecommerceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceBackend.model.Cart;
import com.example.ecommerceBackend.services.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Long userId) {
        Cart cart = cartService.findByUserId(userId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.saveCart(cart);
        return ResponseEntity.ok(createdCart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}