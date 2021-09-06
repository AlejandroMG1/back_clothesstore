package com.example.clothesstore.controller;

import com.example.clothesstore.models.Product;
import com.example.clothesstore.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/{ctrCode}/products")
public class ProductController {
    ProductService productService;
    Map<String, String> crtCodes;

    public ProductController(ProductService productService) {
        this.productService = productService;
        crtCodes = new HashMap<String, String>();
        crtCodes.put("COL","Colombia");
        crtCodes.put("MX", "Mexico");
        crtCodes.put("PE", "Peru");
        crtCodes.put("CHL", "Chile");
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable String ctrCode) {
        String country = crtCodes.get(ctrCode);
        List<Product> todos = productService.getProducts(country);
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping({"/{productId}"})
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product, @PathVariable String ctrCode) {
        String country = crtCodes.get(ctrCode);
        product.setCountry(country);
        Product newProduct = productService.insert(product);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("product", "/api/"+country+"/products/" + newProduct.getId().toString());
        return new ResponseEntity<>(newProduct, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{productId}"})
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) {
        productService.updateProduct(productId, product);
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @DeleteMapping({"/{productId}"})
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
