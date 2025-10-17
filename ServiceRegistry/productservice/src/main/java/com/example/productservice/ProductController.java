package com.example.productservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<String> getProducts() {
        return List.of("Laptop", "Phone", "Tablet");
    }
}
