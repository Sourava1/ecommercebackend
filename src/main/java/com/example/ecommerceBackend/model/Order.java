package com.example.ecommerceBackend.model;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "orders") // Use "orders" instead of "order" to avoid SQL reserved keyword conflicts
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(Long id, User user, List<OrderItem> orderItems, Double totalAmount, LocalDateTime orderDate) {
        this.id = id;
        this.user = user;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
