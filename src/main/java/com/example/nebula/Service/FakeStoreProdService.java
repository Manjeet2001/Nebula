package com.example.nebula.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("/fakeprod")
public class FakeStoreProdService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;

    private String getProductURL = "https://fakestoreapi.com/products/1";

    @Autowired
    public FakeStoreProdService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public String getProdById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity =  restTemplate.getForEntity(getProductURL, String.class);
        return "product fetched from fake store : " + responseEntity.toString();
    }

    @Override
    public List<String> getAllProducts() {
        return List.of();
    }

    @Override
    public void delProductById(Long id) {

    }

    @Override
    public void addProduct(List<String> item) {

    }

    @Override
    public void updateProdById(Long id) {

    }
}
