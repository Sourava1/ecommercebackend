package com.example.ecommerceBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerceBackend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);  // To find a user by username for authentication
}
