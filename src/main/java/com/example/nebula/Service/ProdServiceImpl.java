package com.example.nebula.Service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("/prod")
public class ProdServiceImpl implements ProductService {
    @Override
    public String getProdById(Long id) {
        return "get product with id: " + id;
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
