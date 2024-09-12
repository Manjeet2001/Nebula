package com.example.nebula.Service;

import com.example.nebula.Exceptions.ProductNotFoundException;
import com.example.nebula.Models.Products;

import java.util.List;

public interface ProductService {
    Products getProdById(Long id) throws ProductNotFoundException;

    List<Products> getAllProducts();

    Products deleteProductById(Long id) throws ProductNotFoundException;

    Products addProduct(Products products);

    void updateProdById(Long id, Products products) throws ProductNotFoundException;
}
