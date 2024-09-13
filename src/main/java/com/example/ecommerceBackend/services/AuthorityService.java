package com.example.ecommerceBackend.services;

import com.example.ecommerceBackend.model.Authority;

public interface AuthorityService {
    Authority saveAuthority(Authority authority);
    void deleteAuthority(Long id);
    Authority findById(Long id);
    Authority findByName(String name);
}
