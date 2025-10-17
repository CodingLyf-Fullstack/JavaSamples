package com.example.orderservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final ProductClient productClient;

    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/orders")
    public List<String> getOrders() {
        List<String> products = productClient.getProducts();
        return List.of("Order1 - " + products.get(0), "Order2 - " + products.get(1));
    }
}
