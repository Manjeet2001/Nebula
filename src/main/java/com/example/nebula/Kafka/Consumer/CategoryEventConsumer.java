package com.example.nebula.Kafka.Consumer;

import com.example.nebula.Models.Category;
import com.example.nebula.Repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CategoryEventConsumer {
    @Autowired
    private CategoryRepo categoryRepo;

    @KafkaListener(topics = "Category-Events", groupId = "nebula-group")
    public void consumeCategoryEvent(Category category){
        categoryRepo.save(category);
        System.out.println("Category Event Consumed: " + category.getName());
    }
}
