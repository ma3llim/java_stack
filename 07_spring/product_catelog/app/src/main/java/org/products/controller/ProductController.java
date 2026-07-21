package org.products.controller;

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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<PageResponse<ProductResponseDTO>> getAllProduct(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy, @RequestParam(required = false) String direction) {
        return productService.getProducts(page, size, sortBy, direction);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID productId) throws ProductNotFound {
        return productService.getProductById(productId);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByCategory(@PathVariable String category) {
        List<ProductResponseDTO> products = productService.getProductByCategory(category);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID productId) throws ProductNotFound {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequest) {
        ProductResponseDTO product = productService.addProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable UUID productId, @Valid @RequestBody ProductRequestDTO productRequest) throws ProductNotFound {
        ProductResponseDTO updatedProduct = productService.updateProduct(productId, productRequest);
        return ResponseEntity.ok(updatedProduct);
    }
}
