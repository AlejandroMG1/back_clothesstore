package com.example.clothesstore;

import com.example.clothesstore.models.Product;
import com.example.clothesstore.repositories.ProductRepository;
import com.example.clothesstore.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ProductTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    ProductRepository productRepository;

    Product mxProduct = new Product(1L, "chaqueta", 450.1, 0.0, " ", " ", "Mexico");
    Product mxProduct2 = new Product(2L, "pantalones", 650.1, 0.0, " ", " ", "Mexico");
    Product colProduct = new Product(1L, "chaqueta", 45000D, 0.0, " ", " ", "Colombia");
    Product colProduct2 = new Product(2L, "pantalones", 65000D, 0.0, " ", " ", "Colombia");
    Product peProduct = new Product(1L, "chaqueta", 450.1, 0.0, " ", " ", "Peru");
    Product peProduct2 = new Product(2L, "pantalones", 650.1, 0.0, " ", " ", "Peru");
    Product chlProduct = new Product(1L, "chaqueta", 45000D, 0.0, " ", " ", "Chile");
    Product chlProduct2 = new Product(2L, "pantalones", 65000D, 0.0, " ", " ", "Chile");

    @Test
    void getAllProductsMX() throws Exception {
        List<Product> ProductsList = new ArrayList<Product>(Arrays.asList(mxProduct, mxProduct2));
        when(productService.getProducts("Mexico")).thenReturn(ProductsList);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/MX/products")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }
}
