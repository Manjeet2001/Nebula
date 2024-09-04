package com.example.nebula.Service;

import com.example.nebula.Models.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/prod")
public class ProdServiceImpl implements ProductService {
    @Override
    public Products getProdById(Long id) {
        return null;
    }

    @Override
    public List<Products> getAllProducts() {
        return List.of();
    }

    @Override
    public Products deleteProductById(Long id) {
        return null;
    }

    @Override
    public Products addProduct(Products products) {
        return null;
    }

    @Override
    public void updateProdById(Long id) {

    }
}
