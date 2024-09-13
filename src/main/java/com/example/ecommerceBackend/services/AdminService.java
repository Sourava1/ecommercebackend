package com.example.ecommerceBackend.services;
public interface AdminService {
    String getPlatformInfo();
    void updateInventory(Long productId, int quantity);
}
