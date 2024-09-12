package com.example.nebula.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends BaseModel {
    private Long id;
    private String title;
    private String description;
    private Long price;
    @ManyToOne
    private Category category;

}
