package org.products.services;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.ProtocolException;
import org.products.Dtos.request.ProductRequestDTO;
import org.products.Dtos.response.ProductResponseDTO;
import org.products.entities.Product;
import org.products.enums.Category;
import org.products.exceptions.ProductNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final List<Product> productList = new ArrayList<>();

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

    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        List<ProductResponseDTO> responseDTOS = productList.stream().map(Product::toResponseDTO).collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    public ResponseEntity<ProductResponseDTO> getProductById(UUID productId) throws ProductNotFound {
        Product product = productList.stream()
                .filter(product1 -> product1.getId().equals(productId))
                .findFirst().orElseThrow(() -> new ProductNotFound("Product Not Found of this product ID: " + productId));

        ProductResponseDTO productResponseDTO = product.toResponseDTO();

        return ResponseEntity.ok(productResponseDTO);

    }

    public List<ProductResponseDTO> getProductByCategory(String category) {
        return productList.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .map(Product::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void deleteProductById(UUID productId) throws ProductNotFound {
        if (productId.toString().isEmpty()) {
            throw new IllegalArgumentException("Product ID is required for deleting");
        }
        Product exisitedProduct = productList.stream().filter(product -> product.getId().equals(productId)).findFirst()
                .orElseThrow(() -> new ProductNotFound("Product not found with id: " + productId));

        productList.remove(exisitedProduct);
    }

    public ProductResponseDTO addProduct(ProductRequestDTO productRequest) {
        Product product = Product.builder()
                .id(UUID.randomUUID())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .stock(productRequest.getStock())
                .build();

        productList.add(product);
        return product.toResponseDTO();
    }

    public ProductResponseDTO updateProduct(UUID productId, @Valid ProductRequestDTO productRequest) throws ProductNotFound {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        Product existingProduct = productList.stream().filter(product -> product.getId().equals(productId)).findFirst()
                .orElseThrow(() -> new ProductNotFound("Product not found with id: " + productId));
        existingProduct.setName(productRequest.getName());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setCategory(productRequest.getCategory());
        existingProduct.setStock(productRequest.getStock());

        return existingProduct.toResponseDTO();
    }
}
