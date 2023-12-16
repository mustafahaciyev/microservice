package com.example.orderms.service;

import com.example.orderms.clients.ProductClient;
import com.example.orderms.clients.UserClient;
import com.example.orderms.entity.Orders;
import com.example.orderms.entity.Products;
import com.example.orderms.entity.Users;
import com.example.orderms.events.ProductCreatedEvent;
import com.example.orderms.events.UserCreatedEvent;
import com.example.orderms.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final ProductClient productClient;

//    @KafkaListener(topics = "user-created-topic", groupId = "order-service-group")
//    public void handleUserCreatedEvent(UserCreatedEvent event) {
//        // UserCreatedEvent olayını işleme
//        // Örneğin, kullanıcıya bir hoş geldin mesajı gönderme işlemleri yapılabilir.
//        System.out.println("User Created Event Received: " + event.getUsername());
//    }
//
//    @KafkaListener(topics = "product-created-topic", groupId = "order-service-group")
//    public void handleProductCreatedEvent(ProductCreatedEvent event) {
//        // ProductCreatedEvent olayını işleme
//        // Örneğin, yeni bir ürün eklenmişse bu ürünle ilgili işlemleri yapma
//        System.out.println("Product Created Event Received: " + event.getName());
//    }

    public Orders createOrder(String username, String productName, int quantity) {
        Users user = userClient.getUserByUsername(username);
        Products product = productClient.getProductByName(productName);

        if (user == null || product == null) {
            // Kullanıcı veya ürün bulunamazsa hata işlemleri buraya eklenir.
            throw new RuntimeException("Kullanıcı veya ürün bulunamadı!");
        }

        Orders order = new Orders();
        order.setUserId(user.getId());
        order.setProductId(product.getId());
        order.setQuantity(quantity);

        return orderRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
}
