package com.example.productms.service;

import com.example.productms.entity.Products;
import com.example.productms.event.ProductCreatedEvent;
import com.example.productms.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProducerService producerService;


    public Products createProduct(Products product) {
        Products createdProduct = productRepository.save(product);
        producerService.sendMessage("Product created: " + product.getName());
        return createdProduct;
    }
    public Products getProductByName(String name) {
        return productRepository.findByName(name);
    }

//    public Products createProduct(Products product) {
//        // Ürün oluşturma işlemleri
//
//        // Kafka'ya olay gönderme
//        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
//        productCreatedEvent.setName(product.getName());
//        productCreatedEvent.setPrice(product.getPrice());
//        kafkaTemplate.send("product-created-topic", productCreatedEvent);
//
//        return product;
//    }

    public List<Products> getAllOrders() {
        return productRepository.findAll();
    }
}
