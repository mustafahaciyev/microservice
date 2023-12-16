package com.example.productms.controller;

import com.example.productms.entity.Products;
import com.example.productms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;
    @GetMapping("/{name}")
    public ResponseEntity<Products> getProductByName(@PathVariable String name) {
        Products product = productService.getProductByName(name);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Products>> getAllOrders() {
        List<Products> orders = productService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

}
