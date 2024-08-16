package com.example.productsservice.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "stock-update-topic", groupId = "products-group")
    public void consumeStockUpdate(String message) {
        System.out.println("Consumed stock update message: " + message);
        // Additional logic for handling stock update can be implemented here
    }

    @KafkaListener(topics = "product-deletion-topic", groupId = "products-group")
    public void consumeProductDeletion(String message) {
        System.out.println("Consumed product deletion message: " + message);
        // Additional logic for handling product deletion can be implemented here
    }
}
