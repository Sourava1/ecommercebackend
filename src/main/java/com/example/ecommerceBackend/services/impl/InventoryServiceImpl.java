package com.example.ecommerceBackend.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceBackend.model.Inventory;
import com.example.ecommerceBackend.repository.InventoryRepository;
import com.example.ecommerceBackend.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory findByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void updateInventory(Long productId, int quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory != null) {
            inventory.setQuantity(quantity);
            inventoryRepository.save(inventory);
        }
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
