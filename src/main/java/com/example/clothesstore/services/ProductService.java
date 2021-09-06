package com.example.clothesstore.services;

import com.example.clothesstore.models.Product;
import com.example.clothesstore.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(String country) {
        List<Product> products = new ArrayList<>();
        products.addAll(productRepository.findByCountry(country));
        return products;
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }


    public Product insert(Product todo) {
        return productRepository.save(todo);
    }


    public void updateProduct(Long id, Product product) {
        Product productFromDb = productRepository.findById(id).get();
        productFromDb.setCountry(product.getCountry());
        productFromDb.setDiscount(product.getDiscount());
        productFromDb.setName(product.getName());
        productFromDb.setPrice(product.getPrice());
        productFromDb.setFrontImg(product.getFrontImg());
        productFromDb.setBackImage(product.getBackImage());
        productRepository.save(productFromDb);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
