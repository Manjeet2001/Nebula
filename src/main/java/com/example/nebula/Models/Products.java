package com.example.nebula.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends BaseModel {
    private String title;
    private String description;
    private Long price;
    @ManyToOne
    private Category category;

}
