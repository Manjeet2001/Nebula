package com.example.nebula.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products extends BaseModel {
    private Long id;
    private String title;
    private String desc;
    private Long price;
    private Category category;

}
