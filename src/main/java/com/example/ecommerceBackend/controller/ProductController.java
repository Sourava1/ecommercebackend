package com.example.ecommerceBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerceBackend.model.Product;
import com.example.ecommerceBackend.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getProducts(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String category,
                                     Pageable pageable) {
        if (name != null) {
            return productService.findByName(name, pageable);
        } else if (category != null) {
            return productService.findByCategory(category, pageable);
        }
        return productService.findByName("", pageable); // Return all products if no filter
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
