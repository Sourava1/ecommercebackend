package com.example.ecommerceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecommerceBackend.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByProductId(Long productId);
}
