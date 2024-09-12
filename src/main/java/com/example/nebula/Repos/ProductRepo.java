package com.example.nebula.Repos;

import com.example.nebula.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products, Long> {
}
