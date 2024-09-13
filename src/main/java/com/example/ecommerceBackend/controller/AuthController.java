package com.example.ecommerceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceBackend.model.User;
import com.example.ecommerceBackend.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

		@Autowired
	    private PasswordEncoder passwordEncoder;
	  @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<User> registerUser(@RequestBody User user) {
	        User createdUser = userService.saveUser(user);
	        return ResponseEntity.ok(createdUser);
	    }

	 
	    @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestBody User user) {
	        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
	        if (passwordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    }

}
