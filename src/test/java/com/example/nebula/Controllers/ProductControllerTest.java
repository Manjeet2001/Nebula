package com.example.nebula.Controllers;

import com.example.nebula.Exceptions.ProductNotFoundException;
import com.example.nebula.Models.Products;
import com.example.nebula.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    /*
    * If we don't want to use @SpringBootTest, @AutoWired and @MockBeans
    * i.e. we don't want to use spring we have to manually set up the wiring for the controller as below
    *
    * step-1: remove all above annotations
    * steo-2: add @InjectMocks instead of @AutoWired
    * step-3: add @Mock instead of @MockBeans
    * step-4: @BeforeEach
    *           void setup(){
    *               MockitoAnnotations.initMocks(this);
    *           }
    * */

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void getProdById() throws ProductNotFoundException {
        //Arrange
        Products dummy = new Products();
        dummy.setId(1L);
        dummy.setTitle("dummy");
        when(productService.getProdById(1L)).thenReturn(dummy);

        //Act
        Products products = productController.getProdById(1L);

        //Assert
        assertEquals(1L, products.getId());
    }
    @Test
    void getProductByIdThrowsException() throws ProductNotFoundException {
        //Arrange
//        Products dummy = new Products();
//        dummy.setId(1L);
//        dummy.setTitle("dummy");
        when(productService.getProdById(1L)).thenThrow(new ProductNotFoundException("Product not found"));
        //Act
        assertThrows(ProductNotFoundException.class, () -> productController.getProdById(1L));
    }
}