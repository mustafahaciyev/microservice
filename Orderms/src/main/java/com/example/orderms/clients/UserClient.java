package com.example.orderms.clients;

import com.example.orderms.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userms", url = "http://localhost:8002")
public interface UserClient {
    @GetMapping("/users/{username}")
    Users getUserByUsername(@PathVariable String username);
}