package com.example.ecommerceBackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecommerceBackend.model.Authority;
import com.example.ecommerceBackend.repository.AuthorityRepository;
import com.example.ecommerceBackend.services.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority saveAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public Authority findByName(String name) {
        return authorityRepository.findByName(name);
    }

    @Override
    public void deleteAuthority(Long id) {
        authorityRepository.deleteById(id);
    }

    @Override
    public Authority findById(Long id) {
        return authorityRepository.findById(id).orElseThrow(() -> new RuntimeException("Authority not found"));
    }
}
