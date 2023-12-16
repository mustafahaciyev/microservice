package com.example.orderms.controller;

import com.example.orderms.entity.Orders;
import com.example.orderms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping("/create")
    public ResponseEntity<Orders> createOrder(
            @RequestParam String username,
            @RequestParam String productName,
            @RequestParam int quantity) {
        Orders order = orderService.createOrder(username, productName, quantity);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

}
