package com.example.productsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendStockUpdate(String productId, int stock) {
        String message = String.format("Product ID: %s, New Stock: %d", productId, stock);
        kafkaTemplate.send("stock-update-topic", message);
    }

    public void sendProductDeletion(String productId) {
        String message = String.format("Product ID: %s has been deleted", productId);
        kafkaTemplate.send("product-deletion-topic", message);
    }
}
