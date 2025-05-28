package com.example.nebula.Kafka.Producer;

import com.example.nebula.Models.Products;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductEventProducer {
    @Autowired
    private KafkaTemplate<String, Products> kafkaTemplate;

    private static final String TOPIC = "Product-Events";
    public void send(Products products) {
        kafkaTemplate.send(TOPIC, products);
    }
}
