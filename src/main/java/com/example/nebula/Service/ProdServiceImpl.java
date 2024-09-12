package com.example.nebula.Service;

import com.example.nebula.Exceptions.ProductNotFoundException;
import com.example.nebula.Models.Category;
import com.example.nebula.Models.Products;
import com.example.nebula.Repos.CategoryRepo;
import com.example.nebula.Repos.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("/selfproduct")
public class ProdServiceImpl implements ProductService {

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public ProdServiceImpl(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Products getProdById(Long id) {
        Optional<Products> products = productRepo.findById(id);
        if(products.isPresent()){
            Category category = products.get().getCategory();
        }
        return products.get();
    }

    @Override
    public List<Products> getAllProducts() {
        List<Products> products = productRepo.findAll();
        return products;
    }

    @Override
    public Products deleteProductById(Long id) {
        Optional<Products> products = productRepo.findById(id);
        if(products.isPresent()){
            productRepo.deleteById(id);
        }
        return products.get();
    }

    @Override
    public Products addProduct(Products products) {
        Optional<Category> categoryOptional = this.categoryRepo.findByName(products.getCategory().getName());
        if(categoryOptional.isPresent()){
            products.setCategory(categoryOptional.get());
        }
        else {
            Category category = categoryRepo.save(products.getCategory());
            products.setCategory(category);
        }
        return this.productRepo.save(products);
    }

    @Override
    public void updateProdById(Long id, Products product) throws ProductNotFoundException {
        Optional<Products> existingProductOptional = productRepo.findById(id);
        if(existingProductOptional.isPresent()){
            Products existingProduct = existingProductOptional.get();
            existingProduct.setTitle(product.getTitle());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());

            Optional<Category> optionalCategory = this.categoryRepo.findByName(product.getCategory().getName());
            if(optionalCategory.isPresent()){
                existingProduct.setCategory(optionalCategory.get());
            }
            else {
                Category category = categoryRepo.save(product.getCategory());
                existingProduct.setCategory(category);
            }
            this.productRepo.save(existingProduct);
        }
        else{
            throw new ProductNotFoundException("Product with id: " + id + "don't exist");
        }
    }
}
