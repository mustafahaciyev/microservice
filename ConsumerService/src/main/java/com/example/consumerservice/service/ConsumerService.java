package com.example.consumerservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "test-topic", groupId = "group-id")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Burada gelen mesajı işleyebilirsiniz.
//         if (message.contains("User created")) { // kullanıcı mesajı
//             userService.handleUserCreationMessage(message);
//         } else if (message.contains("Product created")) { // ürün mesajı
//             productService.handleProductCreationMessage(message);
//         }
    }
}
