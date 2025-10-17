package com.example.orderservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "productservice")
public interface ProductClient {
    @GetMapping("/products")
    List<String> getProducts();
}

