package org.products.controller;

import lombok.RequiredArgsConstructor;
import org.products.entities.Product;
import org.products.exceptions.ProductNotFound;
import org.products.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable UUID productId) throws ProductNotFound {
        return productService.getProductById(productId);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return productService.getProductByCategory(category);
    }

    @DeleteMapping("{productId}")
    public Object deleteProduct(@PathVariable UUID productId) throws ProductNotFound {
        return productService.deleteProductById(productId);
    }
}
