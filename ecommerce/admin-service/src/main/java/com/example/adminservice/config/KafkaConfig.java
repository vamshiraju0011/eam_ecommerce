package com.example.adminservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic adminEventsTopic() {
        return new NewTopic("admin-events-topic", 1, (short) 1);
    }
}