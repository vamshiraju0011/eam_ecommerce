package com.example.productsservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic stockUpdateTopic() {
        return new NewTopic("stock-update-topic", 1, (short) 1);
    }

    @Bean
    public NewTopic productDeletionTopic() {
        return new NewTopic("product-deletion-topic", 1, (short) 1);
    }
}