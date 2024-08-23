package com.example.nebula.Service;

import java.util.List;

public interface ProductService {
    String getProdById(Long id);

    List<String> getAllProducts();

    void delProductById(Long id);

    void addProduct(List<String> item);

    void updateProdById(Long id);
}
