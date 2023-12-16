package com.example.userms.service;

import com.example.userms.entity.Users;
import com.example.userms.events.UserCreatedEvent;
import com.example.userms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ProducerService producerService;


    public Users createUser(Users user) {
        Users createdUser = userRepository.save(user);
        producerService.sendMessage("User created: " + user.getUsername());
        return createdUser;
    }
    public Users getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    public Users createUser(Users user) {
//        // Kullanıcı oluşturma işlemleri
//
//        // Kafka'ya olay gönderme
//        UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
//        userCreatedEvent.setUsername(user.getUsername());
//        userCreatedEvent.setEmail(user.getEmail());
//        kafkaTemplate.send("user-created-topic", userCreatedEvent);
//
//        return user;
//    }

    public List<Users> getAllOrders() {
        return userRepository.findAll();
    }
}
