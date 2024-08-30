package com.example.nebula.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
* DTO are helpful to avoid the difference between the data coming from API and the data we want.
* using DTO we can also change the data according to our convenience
* In our example we changed the String Category(given by API) to Category Object.
* We also discarded the data "Rating" coming from API.
* */
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private Long price;
    private String category;
}
