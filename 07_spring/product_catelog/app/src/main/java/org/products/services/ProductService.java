package org.products.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.products.entities.Product;
import org.products.enums.Category;
import org.products.exceptions.ProductNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void init() {
        Product product1 = Product.builder().id(UUID.randomUUID()).name("iPhone 15 Pro Max").description("6.7-inch OLED display, A17 Pro chip, 256GB storage").price(1199.99).category(Category.MOBILE.toString()).stock(45.0).build();
        Product product2 = Product.builder().id(UUID.randomUUID()).name("MacBook Pro 16-inch").description("M3 Pro chip, 36GB RAM, 1TB SSD, Space Black").price(2499.00).category(Category.COMPUTERS.toString()).stock(23.0).build();
        Product product3 = Product.builder().id(UUID.randomUUID()).name("Artisan Sourdough Bread").description("Handcrafted, naturally leavened, 100% organic flour").price(6.99).category(Category.FOOD.toString()).stock(150.0).build();
        Product product4 = Product.builder().id(UUID.randomUUID()).name("Nike Air Max 270").description("Air Max cushioning, breathable mesh upper, stylish design").price(149.99).category(Category.FOOTWEAR.toString()).stock(67.0).build();
        Product product5 = Product.builder().id(UUID.randomUUID()).name("Samsung Galaxy S24 Ultra").description("6.8-inch AMOLED, 200MP camera, S Pen included").price(1399.99).category(Category.MOBILE.toString()).stock(32.0).build();

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    public List<Product> getProducts() {
        return productList;
    }

    public Product getProductById(UUID productId) {
        return productList.stream()
                .filter(product1 -> product1.getId().equals(productId))
                .findFirst().orElseThrow(() -> {
                            new ProductNotFound("Product Not Found of this product ID: " + productId);
                            return null;
                        }
                );
    }
}
