package com.example.nebula.Service;

import com.example.nebula.Models.Products;

import java.util.List;

public interface ProductService {
    Products getProdById(Long id);

    List<Products> getAllProducts();

    void delProductById(Long id);

    void addProduct(List<String> item);

    void updateProdById(Long id);
}
