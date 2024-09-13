package com.example.ecommerceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceBackend.services.AdminService;

@RestController
@RequestMapping("/api/admin")  
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Example endpoint for viewing platform-wide information
    @GetMapping("/platform-info")
    public ResponseEntity<String> getPlatformInfo() {
        String info = adminService.getPlatformInfo();
        return ResponseEntity.ok(info);
    }

    // Example endpoint for managing inventory
    @PutMapping("/inventory/{productId}")
    public ResponseEntity<Void> updateInventory(@PathVariable Long productId, @RequestParam int quantity) {
        adminService.updateInventory(productId, quantity);
        return ResponseEntity.noContent().build();
    }
    
   
}
