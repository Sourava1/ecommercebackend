package com.example.ecommerceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecommerceBackend.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(String name);
}
