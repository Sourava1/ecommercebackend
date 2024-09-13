package com.example.ecommerceBackend.services;

import com.example.ecommerceBackend.model.Inventory;

public interface InventoryService {
    Inventory findByProductId(Long productId);
    Inventory saveInventory(Inventory inventory);
    void updateInventory(Long productId, int quantity);
    void deleteInventory(Long id);
}