package com.example.ecommerceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceBackend.model.CartItem;
import com.example.ecommerceBackend.services.CartItemService;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem) {
        CartItem createdCartItem = cartItemService.saveCartItem(cartItem);
        return ResponseEntity.ok(createdCartItem);
    }

    @PutMapping("/{cartId}/product/{productId}")
    public ResponseEntity<Void> updateCartItemQuantity(
            @PathVariable Long cartId,
            @PathVariable Long productId,
            @RequestParam int quantity) {
        cartItemService.updateCartItemQuantity(cartId, productId, quantity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}
