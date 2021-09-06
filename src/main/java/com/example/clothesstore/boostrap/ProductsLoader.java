package com.example.clothesstore.boostrap;

import com.example.clothesstore.models.Product;
import com.example.clothesstore.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductsLoader implements CommandLineRunner {
    public final ProductRepository productRepository;

    public ProductsLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadProducts();
    }

    private void loadProducts() {
        if (productRepository.count() == 0) {
            productRepository.save(
                    Product.builder()
                            .Name("chaqueta x")
                            .price(60000.0)
                            .Discount(0.0)
                            .backImage("")
                            .frontImg("")
                            .country("Colombia")
                            .build()
            );
            productRepository.save(
                    Product.builder()
                            .Name("chaqueta 7")
                            .price(600.78)
                            .Discount(0.0)
                            .backImage("")
                            .frontImg("")
                            .country("Mexico")
                            .build()
            );
            System.out.println("Sample Todos Loaded");
        }
    }
}
