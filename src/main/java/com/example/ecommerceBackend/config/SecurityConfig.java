package com.example.ecommerceBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import com.example.ecommerceBackend.services.impl.UserServiceImpl;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	

//    private final UserServiceImpl userServiceImpl;
//	 public SecurityConfig(UserServiceImpl userServiceImpl) {
//	        this.userServiceImpl = userServiceImpl;
//	    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    	 http.authorizeHttpRequests((requests) -> requests
    			 .requestMatchers("/h2-console/**").permitAll()
                 .requestMatchers("/api/auth/**").permitAll()
                 .requestMatchers("/api/admin/**").hasRole("ADMIN")
                 .requestMatchers("/api/users/**").hasRole("USER")
                 .anyRequest().authenticated()
                )
          //.sessionManagement(session -> session
          //      .sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Stateless session (JWT/Token-based auth)
             .httpBasic(withDefaults())  // Basic authentication for now, can be switched to JWT later
             .csrf().disable()  // Disable CSRF for stateless authentication
             .headers(headers -> headers
                 .frameOptions(frameOptions -> frameOptions.sameOrigin()));  // Allow H2-console

         return http.build();
    	
    }
    
//    @Bean
//    public UserDetailsService userDetailService() {
//    	
//        UserDetails user1 = User.withUsername("user")
//                .password("{noop}password")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}admin")
//                .roles("ADMIN")
//                .build();
////
////     
////       return new InMemoryUserDetailsManager(user1, admin);
//
//        }


    
    
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
	}
   
//   @Bean
//   public UserDetailsService userDetailsService() {
//	   return userServiceImpl;  // Assuming UserService implements UserDetailsService
//   }
}
