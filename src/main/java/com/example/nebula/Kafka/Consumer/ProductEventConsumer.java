package com.example.nebula.Kafka.Consumer;

import com.example.nebula.Models.Products;
import com.example.nebula.Repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductEventConsumer {
    @Autowired
    private ProductRepo productRepo;

    @KafkaListener(topics = "Product-Events", groupId = "nebula-group")
    public void consumeProductEvent(Products products){
        productRepo.save(products);
        System.out.println("Consumed Product Event: " + products.getTitle());
    }
}
