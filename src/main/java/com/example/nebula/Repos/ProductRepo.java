package com.example.nebula.Repos;

import com.example.nebula.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Products, Long> {
}
