package com.example.ecommerceBackend.services.impl;

import org.springframework.stereotype.Service;
import com.example.ecommerceBackend.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Override
    public String getPlatformInfo() {
        return "E-commerce Platform okkkkkkkkkkkkkkkkkkkk";
    }

    @Override
    public void updateInventory(Long productId, int quantity) {
        System.out.println("Updating inventory for product ID: " + productId + " with quantity: " + quantity);
    }
}
