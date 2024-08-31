package com.example.nebula.Service;

import com.example.nebula.Exceptions.ProductNotFoundException;
import com.example.nebula.Models.Category;
import com.example.nebula.Models.Products;
import com.example.nebula.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service("/fakeprod")
public class FakeStoreProdService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;

    private String getProductURL = "https://fakestoreapi.com/products/{id}";

    private String getAllProductsURL = "https://fakestoreapi.com/products";

    @Autowired
    public FakeStoreProdService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public Products getProdById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.getForEntity(getProductURL, FakeStoreProductDto.class, id);

        if(responseEntity.getBody() == null){
            throw new ProductNotFoundException("Product not found for id: " + id);
        }
        return getProductfromfakestoreDto(responseEntity.getBody());
    }

    @Override
    public List<Products> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(getAllProductsURL, FakeStoreProductDto[].class);
        List<Products> productsList = new LinkedList<>();
        for (FakeStoreProductDto dto : responseEntity.getBody()) {
            productsList.add(getProductfromfakestoreDto(dto));
        }
        return productsList;
    }

    @Override
    public void delProductById(Long id) {

    }

    @Override
    public void addProduct(List<String> item) {

    }

    @Override
    public void updateProdById(Long id) {

    }

    private Products getProductfromfakestoreDto(FakeStoreProductDto fakeStoreProductDto) {
        Products products = new Products();
        products.setId(fakeStoreProductDto.getId());
        products.setTitle(fakeStoreProductDto.getTitle());
        products.setDesc(fakeStoreProductDto.getDescription());
        products.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        products.setCategory(category);

        return products;
    }
}
