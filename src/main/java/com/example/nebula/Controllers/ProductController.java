package com.example.nebula.Controllers;

import com.example.nebula.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService  productService;

    @Autowired
    public ProductController(@Qualifier("/fakeprod") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProdById(@PathVariable("id") Long id) {
        return productService.getProdById(id);
    }

    @GetMapping()
    public List<String> getAllProducts() {
        return productService.getAllProducts();
    }

    public void delProductById(Long id){
        productService.delProductById(id);
    }

    @PostMapping("/")
    public void addProduct(List<String> item){
        productService.addProduct(item);
    }

}
