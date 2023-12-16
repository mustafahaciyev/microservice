package com.example.orderms.clients;

import com.example.orderms.entity.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productms", url = "http://localhost:8001")
public interface ProductClient {
    @GetMapping("/products/{name}")
    Products getProductByName(@PathVariable String name);
}
