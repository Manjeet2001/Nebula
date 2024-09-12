package com.example.nebula.Service;

import com.example.nebula.Exceptions.ProductNotFoundException;
import com.example.nebula.Models.Category;
import com.example.nebula.Models.Products;
import com.example.nebula.dtos.FakeStoreProductDto;
import com.example.nebula.thirdPartyClients.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service("/fakeprod")
public class FakeStoreProdService implements ProductService {

    private FakeStoreClient fakeStoreClient;

    @Autowired
    public FakeStoreProdService(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public Products getProdById(Long id) throws ProductNotFoundException {
        return getProductfromfakestoreDto(fakeStoreClient.getProdById(id));
    }

    @Override
    public List<Products> getAllProducts() {
        List<Products> productsList = new LinkedList<>();
        for (FakeStoreProductDto dto : fakeStoreClient.getAllProducts()) {
            productsList.add(getProductfromfakestoreDto(dto));
        }
        return productsList;
    }

    @Override
    public Products deleteProductById(Long id) {
        return getProductfromfakestoreDto(fakeStoreClient.deleteProductById(id));
    }

    @Override
    public Products addProduct(Products products) {
        return getProductfromfakestoreDto(fakeStoreClient.addProduct(getFakeStoreProductFromProduct(products)));
    }


    @Override
    public void updateProdById(Long id, Products products) throws ProductNotFoundException {
        fakeStoreClient.updateProdById(id, getFakeStoreProductFromProduct(products));
    }

    private Products getProductfromfakestoreDto(FakeStoreProductDto fakeStoreProductDto) {
        Products products = new Products();
        products.setId(fakeStoreProductDto.getId());
        products.setTitle(fakeStoreProductDto.getTitle());
        products.setDescription(fakeStoreProductDto.getDescription());
        products.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        products.setCategory(category);

        return products;
    }

    private FakeStoreProductDto getFakeStoreProductFromProduct(Products products) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(products.getTitle());
        fakeStoreProductDto.setCategory(products.getCategory().getName());
        fakeStoreProductDto.setPrice(products.getPrice());
        fakeStoreProductDto.setDescription(products.getDescription());

        return fakeStoreProductDto;
    }
}
