package com.example.ecommerceBackend.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.ecommerceBackend.model.User;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    User saveUser(User user);
    void deleteUser(Long id);
    User findById(Long id);
	List<User> findAllUsers();
}
