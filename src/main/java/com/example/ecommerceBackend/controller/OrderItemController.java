//package com.example.ecommerceBackend.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.ecommerceBackend.model.OrderItem;
//import com.example.ecommerceBackend.services.OrderItemService;
//
//@RestController
//@RequestMapping("/api/order-items")
//public class OrderItemController {
//
//    @Autowired
//    private OrderItemService orderItemService;
//
//    @PostMapping
//    public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem orderItem) {
//        OrderItem createdOrderItem = orderItemService.saveOrderItem(orderItem);
//        return ResponseEntity.ok(createdOrderItem);
//    }
//    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
//        orderItemService.deleteOrderItem(id);
//        return ResponseEntity.noContent().build();
//    }
//}

package com.example.ecommerceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerceBackend.model.OrderItem;
import com.example.ecommerceBackend.services.OrderItemService;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.saveOrderItem(orderItem);
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
    }
}


