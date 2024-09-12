package com.example.nebula.thirdPartyClients;

import com.example.nebula.Exceptions.ProductNotFoundException;
import com.example.nebula.Models.Products;
import com.example.nebula.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;

    private String getProductURL = "https://fakestoreapi.com/products/{id}";

    private String genericProductsURL = "https://fakestoreapi.com/products";


    @Autowired
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto getProdById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(getProductURL, FakeStoreProductDto.class, id);

        if (responseEntity.getBody() == null) {
            throw new ProductNotFoundException("Product not found for id: " + id);
        }
        return responseEntity.getBody();
    }

    public FakeStoreProductDto[] getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(genericProductsURL, FakeStoreProductDto[].class);
        return responseEntity.getBody();
    }

    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseEntityResponseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.execute(getProductURL, HttpMethod.DELETE, requestCallback, responseEntityResponseExtractor, id);
        return responseEntity.getBody();
    }

    public FakeStoreProductDto addProduct(FakeStoreProductDto fakeStoreProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProductsURL,
                fakeStoreProductDto, FakeStoreProductDto.class);
        return responseEntity.getBody();
    }

    public FakeStoreProductDto updateProdById(Long id, FakeStoreProductDto fakeStoreProductDto) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(getProductURL, FakeStoreProductDto.class, id);
        if (responseEntity.getBody() != null) {
            if (fakeStoreProductDto.getTitle() != null)
                responseEntity.getBody().setTitle(fakeStoreProductDto.getTitle());
            if (fakeStoreProductDto.getDescription() != null)
                responseEntity.getBody().setDescription(fakeStoreProductDto.getDescription());
            if (fakeStoreProductDto.getPrice() != null)
                responseEntity.getBody().setPrice(fakeStoreProductDto.getPrice());
            if (fakeStoreProductDto.getCategory() != null)
                responseEntity.getBody().setCategory(fakeStoreProductDto.getCategory());
            restTemplate.put(getProductURL, fakeStoreProductDto, id);
            //System.out.println("product updated");
        } else {
            throw new ProductNotFoundException("product with id: " + id + " not found");
        }
        return fakeStoreProductDto;
    }

}
