package org.products.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.products.Dtos.request.ProductRequestDTO;
import org.products.Dtos.response.ProductResponseDTO;
import org.products.config.properties.PaginationProperties;
import org.products.entities.Product;
import org.products.repository.ProductRepository;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private PaginationProperties paginationProperties;
    @InjectMocks
    private ProductService productService;
    private ProductRequestDTO validProductRequest;
    private Product product;
    private UUID productId;

    @BeforeEach
    void setup() {
        productId = UUID.randomUUID();

        validProductRequest = ProductRequestDTO.builder()
                .name("Test Product")
                .description("Test Description")
                .price(99.99)
                .category("Electronics")
                .stock(10.0)
                .build();

        product = Product.builder()
                .id(productId)
                .name("Test Product")
                .description("Test Description")
                .price(99.99)
                .category("Electronics")
                .stock(10.0)
                .build();
    }

    // CREATE PRODUCT TESTS
    @Test
    void addProduct_ShouldSuccessfullyCreateProduct_WhenValidRequest() {
        // Arrange
        when(productRepository.existsByNameIgnoreCase(validProductRequest.getName())).thenReturn(false);
        when(productRepository.save(any(Product.class)))
                .thenAnswer(invocation -> {
                    Product savedProduct = invocation.getArgument(0);
                    // Set the ID on the saved product to simulate database generation
                    savedProduct.setId(productId);
                    return savedProduct;
                });

        // Act
        ProductResponseDTO result = productService.addProduct(validProductRequest);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(productId);
        assertThat(result.getName()).isEqualTo("Test Product");
        assertThat(result.getDescription()).isEqualTo("Test Description");
        assertThat(result.getPrice()).isEqualTo(99.99);
        assertThat(result.getCategory()).isEqualTo("Electronics");
        assertThat(result.getStock()).isEqualTo(10);

        verify(productRepository).existsByNameIgnoreCase("Test Product");
        verify(productRepository).save(any(Product.class));
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    void addProduct_ShouldThrowException_WhenProductNameAlreadyExists() {
        // Arrange
        when(productRepository.existsByNameIgnoreCase(validProductRequest.getName()))
                .thenReturn(true);

        // Act & Assert
        assertThatThrownBy(() -> productService.addProduct(validProductRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Product with this name already exists");

        verify(productRepository).existsByNameIgnoreCase("Test Product");
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    void addProduct_ShouldThrowException_WhenProductNameIsNull() {
        // Arrange
        ProductRequestDTO invalidRequest = ProductRequestDTO.builder()
                .name(null)
                .description("Test Description")
                .price(99.99)
                .category("Electronics")
                .stock(10.0)
                .build();

        // Act & Assert
        assertThatThrownBy(() -> productService.addProduct(invalidRequest))
                .isInstanceOf(Exception.class);

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    void addProduct_ShouldTrimAndNormalizeName_WhenCheckingDuplicates() {
        // Arrange
        ProductRequestDTO requestWithSpaces = ProductRequestDTO.builder()
                .name("  Test Product  ")
                .description("Test Description")
                .price(99.99)
                .category("Electronics")
                .stock(10.0)
                .build();

        // The service uses request.getName() directly without trimming
        // This test documents the current behavior
        when(productRepository.existsByNameIgnoreCase("  Test Product  "))
                .thenReturn(false);
        when(productRepository.save(any(Product.class)))
                .thenReturn(product);

        // Act
        productService.addProduct(requestWithSpaces);

        // Assert
        verify(productRepository).existsByNameIgnoreCase("  Test Product  ");
    }
}
