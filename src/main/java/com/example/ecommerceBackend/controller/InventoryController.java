package com.example.ecommerceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceBackend.model.Inventory;
import com.example.ecommerceBackend.services.InventoryService;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

	@Autowired
    private InventoryService inventoryService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<Inventory> getInventoryByProductId(@PathVariable Long productId) {
        Inventory inventory = inventoryService.findByProductId(productId);
        return ResponseEntity.ok(inventory);
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        Inventory createdInventory = inventoryService.saveInventory(inventory);
        return ResponseEntity.ok(createdInventory);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateInventory(@PathVariable Long productId, @RequestParam int quantity) {
        inventoryService.updateInventory(productId, quantity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }

}