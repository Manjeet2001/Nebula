package com.example.nebula.Service;

import com.example.nebula.Models.Category;
import com.example.nebula.Models.Products;
import com.example.nebula.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("/fakeprod")
public class FakeStoreProdService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;

    private String getProductURL = "https://fakestoreapi.com/products/1";

    @Autowired
    public FakeStoreProdService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public Products getProdById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.getForEntity(getProductURL, FakeStoreProductDto.class);
        return getProductfromfakestoreDto(responseEntity.getBody());
    }

    @Override
    public List<String> getAllProducts() {
        return List.of();
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
