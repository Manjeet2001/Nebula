package com.example.nebula.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    @GetMapping("/{id}")
    public String getProdById(@PathVariable("id") Long id) {
        return "get product by id: " + id;
    }

    @GetMapping()
    public List<String> getAllProducts() {
        return Collections.emptyList();
    }

}
