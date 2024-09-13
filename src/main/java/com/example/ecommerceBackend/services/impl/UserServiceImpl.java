package com.example.ecommerceBackend.services.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerceBackend.model.Role;
import com.example.ecommerceBackend.model.User;
import com.example.ecommerceBackend.repository.UserRepository;
import com.example.ecommerceBackend.services.UserService;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {

//    @Autowired
//    private UserRepository userRepository;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        
////        user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
////        return user; // User implements UserDetails
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername())
//                .password(user.getPassword())
//                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
//                .build();
//    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        		

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            getAuthorities(user)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }



    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
            
    }

    @Override
    public User saveUser(User user) {
//    	user.setPassword(user.getPassword());
    	user.setPassword(passwordEncoder.encode(user.getPassword())); 
    	//user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    	return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
