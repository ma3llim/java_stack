package org.products.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.products.config.properties.PaginationProperties;
import org.products.entities.Product;
import org.products.repository.ProductRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private PaginationProperties paginationProperties;
    private ProductService productService;
    private Product testProduct;
    private UUID testProductId;

    @BeforeEach
    void setup() {
        productService = new ProductService(productRepository, paginationProperties);

        // Create a test product for reuse
        testProductId = UUID.randomUUID();
        testProduct = Product.builder()
                .id(testProductId)
                .name("Laptop")
                .description("Gaming Laptop")
                .price(999.99)
                .category("Electronics")
                .stock(10.0)
                .build();
    }

    @Test
    void testMockWorking() {
        when(productRepository.count()).thenReturn(10L);
        assertEquals(10L, productRepository.count());
        System.out.println("✅ Test 1: Mock works!");
    }

}
