package com.example.ecommerceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ecommerceBackend.model.Authority;
import com.example.ecommerceBackend.services.AuthorityService;

@RestController
@RequestMapping("/api/authorities")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @PostMapping
    public ResponseEntity<Authority> createAuthority(@RequestBody Authority authority) {
        return ResponseEntity.ok(authorityService.saveAuthority(authority));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Authority> getAuthorityById(@PathVariable Long id) {
        return ResponseEntity.ok(authorityService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Authority> getAuthorityByName(@PathVariable String name) {
        return ResponseEntity.ok(authorityService.findByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthority(@PathVariable Long id) {
        authorityService.deleteAuthority(id);
        return ResponseEntity.noContent().build();
    }
}
