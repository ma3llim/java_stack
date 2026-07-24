package org.products.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.osgi.annotation.versioning.ProviderType;
import org.products.Dtos.request.ProductRequestDTO;
import org.products.Dtos.response.PageResponse;
import org.products.Dtos.response.ProductResponseDTO;
import org.products.entities.Product;
import org.products.exceptions.ProductNotFound;
import org.products.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Get all products")
    @GetMapping
    public ResponseEntity<PageResponse<ProductResponseDTO>> getAllProduct(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy, @RequestParam(required = false) String direction,
            @RequestParam(required = false) String search, @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return productService.getProducts(page, size, sortBy, direction, search, minPrice, maxPrice);
    }

    @Operation(summary = "Get products by ID")
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID productId) throws ProductNotFound {
        return productService.getProductById(productId);
    }

    @Operation(summary = "Get products by Category")
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByCategory(@PathVariable String category) {
        List<ProductResponseDTO> products = productService.getProductByCategory(category);
        return ResponseEntity.ok(products);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete products by ID")
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID productId) throws ProductNotFound {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Add new product")
    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequest) {
        ProductResponseDTO product = productService.addProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Operation(summary = "Update the product by id")
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable UUID productId, @Valid @RequestBody ProductRequestDTO productRequest) throws ProductNotFound {
        ProductResponseDTO updatedProduct = productService.updateProduct(productId, productRequest);
        return ResponseEntity.ok(updatedProduct);
    }
}