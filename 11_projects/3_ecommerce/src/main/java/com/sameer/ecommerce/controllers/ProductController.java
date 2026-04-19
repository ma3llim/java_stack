package com.sameer.ecommerce.controllers;

import com.sameer.ecommerce.model.Product;
import com.sameer.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId){
        Product product = productService.getProductById(productId);

        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value ="product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(@RequestPart("product") String productJson, @RequestPart("imageFile") MultipartFile imageFile){
        try {
            Product product = objectMapper.readValue(productJson, Product.class);
            Product saveProduct = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    };
}
