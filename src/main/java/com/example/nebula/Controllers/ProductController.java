package com.example.nebula.Controllers;

import com.example.nebula.Exceptions.ProductNotFoundException;
import com.example.nebula.Models.Products;
import com.example.nebula.Service.ProductService;
import com.example.nebula.dtos.ExceptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService  productService;

    @Autowired
    public ProductController(@Qualifier("/selfproduct") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Products getProdById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProdById(id);
    }

    @GetMapping()
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public Products delProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.deleteProductById(id);
    }

    @PostMapping
    public Products createProduct(@RequestBody Products products){
        return productService.addProduct(products);
    }

    @PostMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Products products) throws ProductNotFoundException {
        productService.updateProdById(id, products);
    }


}
