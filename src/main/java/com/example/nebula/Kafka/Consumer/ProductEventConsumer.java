package com.example.nebula.Kafka.Consumer;

import com.example.nebula.Models.Products;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductEventConsumer {
    @KafkaListener(topics = "Product-Events", groupId = "nebula-group")
    public void consumeProductEvent(Products products){
        System.out.println("Consumed Product Event: " + products.getTitle());
    }
}
