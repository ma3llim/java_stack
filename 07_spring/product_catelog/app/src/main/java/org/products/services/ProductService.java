package org.products.services;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.products.Dtos.request.ProductRequestDTO;
import org.products.Dtos.response.PageResponse;
import org.products.Dtos.response.ProductResponseDTO;
import org.products.config.AppProperties;
import org.products.config.PaginationProperties;
import org.products.entities.Product;
import org.products.enums.Category;
import org.products.exceptions.ProductNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final List<Product> productList = new ArrayList<>();
    private final PaginationProperties paginationProperties;

    @PostConstruct
    public void init() {
        Product product1 = Product.builder().id(UUID.randomUUID()).name("iPhone 15 Pro Max").description("6.7-inch OLED display, A17 Pro chip, 256GB storage").price(1199.99).category(Category.MOBILE.toString()).stock(45.0).build();
        Product product2 = Product.builder().id(UUID.randomUUID()).name("Samsung Galaxy S24 Ultra").description("6.8-inch AMOLED display, Snapdragon 8 Gen 3, 512GB storage").price(1299.99).category(Category.MOBILE.toString()).stock(32.0).build();
        Product product3 = Product.builder().id(UUID.randomUUID()).name("Google Pixel 8 Pro").description("6.7-inch LTPO OLED, Tensor G3 chip, 128GB storage").price(999.00).category(Category.MOBILE.toString()).stock(28.0).build();
        Product product4 = Product.builder().id(UUID.randomUUID()).name("OnePlus 12").description("6.82-inch AMOLED, Snapdragon 8 Gen 3, 256GB storage").price(899.99).category(Category.MOBILE.toString()).stock(50.0).build();
        Product product5 = Product.builder().id(UUID.randomUUID()).name("Xiaomi 14 Ultra").description("6.73-inch AMOLED, Snapdragon 8 Gen 3, 512GB storage").price(1099.00).category(Category.MOBILE.toString()).stock(22.0).build();
        Product product6 = Product.builder().id(UUID.randomUUID()).name("MacBook Pro 16-inch M3 Max").description("16.2-inch Liquid Retina XDR, M3 Max chip, 36GB RAM, 1TB SSD").price(3499.00).category(Category.COMPUTERS.toString()).stock(15.0).build();
        Product product7 = Product.builder().id(UUID.randomUUID()).name("Dell XPS 15").description("15.6-inch FHD+, Intel Core i7-13700H, 16GB RAM, 512GB SSD").price(1799.99).category(Category.COMPUTERS.toString()).stock(20.0).build();
        Product product8 = Product.builder().id(UUID.randomUUID()).name("ASUS ROG Zephyrus G14").description("14-inch QHD, AMD Ryzen 9 7940HS, RTX 4060, 16GB RAM").price(1599.99).category(Category.COMPUTERS.toString()).stock(18.0).build();
        Product product9 = Product.builder().id(UUID.randomUUID()).name("Lenovo ThinkPad X1 Carbon").description("14-inch WUXGA, Intel Core i7-1365U, 16GB RAM, 512GB SSD").price(1899.00).category(Category.COMPUTERS.toString()).stock(25.0).build();
        Product product10 = Product.builder().id(UUID.randomUUID()).name("HP Spectre x360").description("13.5-inch 3K2K OLED, Intel Core i7-1355U, 16GB RAM, 1TB SSD").price(1449.99).category(Category.COMPUTERS.toString()).stock(30.0).build();
        Product product11 = Product.builder().id(UUID.randomUUID()).name("Organic Quinoa Grain").description("1kg pack, certified organic, gluten-free superfood").price(12.99).category(Category.FOOD.toString()).stock(200.0).build();
        Product product12 = Product.builder().id(UUID.randomUUID()).name("Artisan Sourdough Bread").description("Freshly baked, 800g loaf, naturally fermented").price(6.49).category(Category.FOOD.toString()).stock(75.0).build();
        Product product13 = Product.builder().id(UUID.randomUUID()).name("Cold-Pressed Extra Virgin Olive Oil").description("500ml, first cold press, imported from Tuscany").price(24.99).category(Category.FOOD.toString()).stock(120.0).build();
        Product product14 = Product.builder().id(UUID.randomUUID()).name("Dark Chocolate 85% Cocoa").description("100g bar, single-origin Ecuadorian cacao").price(5.99).category(Category.FOOD.toString()).stock(150.0).build();
        Product product15 = Product.builder().id(UUID.randomUUID()).name("Premium Matcha Green Tea Powder").description("50g ceremonial grade, stone-ground from Japan").price(29.99).category(Category.FOOD.toString()).stock(85.0).build();
        Product product16 = Product.builder().id(UUID.randomUUID()).name("Nike Air Max 90").description("Men's running shoes, breathable mesh upper, Air cushioning").price(129.99).category(Category.FOOTWEAR.toString()).stock(60.0).build();
        Product product17 = Product.builder().id(UUID.randomUUID()).name("Adidas Ultraboost Light").description("Performance running shoes, Light BOOST midsole, Primeknit upper").price(189.99).category(Category.FOOTWEAR.toString()).stock(40.0).build();
        Product product18 = Product.builder().id(UUID.randomUUID()).name("New Balance 990v6").description("Made in USA, premium suede and mesh, ENCAP midsole").price(199.99).category(Category.FOOTWEAR.toString()).stock(35.0).build();
        Product product19 = Product.builder().id(UUID.randomUUID()).name("Converse Chuck Taylor All-Star").description("Classic high-top canvas sneakers, rubber sole").price(64.99).category(Category.FOOTWEAR.toString()).stock(100.0).build();
        Product product20 = Product.builder().id(UUID.randomUUID()).name("Timberland Premium 6-Inch Boots").description("Waterproof leather, padded collar, rubber lug outsole").price(179.99).category(Category.FOOTWEAR.toString()).stock(45.0).build();
        Product product21 = Product.builder().id(UUID.randomUUID()).name("iPad Pro 12.9-inch M2").description("12.9-inch Liquid Retina XDR, M2 chip, 256GB Wi-Fi").price(1099.00).category(Category.COMPUTERS.toString()).stock(25.0).build();
        Product product22 = Product.builder().id(UUID.randomUUID()).name("Sony WH-1000XM5 Headphones").description("Wireless noise-canceling, 30-hour battery, LDAC support").price(399.99).category(Category.MOBILE.toString()).stock(55.0).build();
        Product product23 = Product.builder().id(UUID.randomUUID()).name("Samsung Galaxy Tab S9 Ultra").description("14.6-inch AMOLED, Snapdragon 8 Gen 2, 256GB, S Pen included").price(1199.99).category(Category.COMPUTERS.toString()).stock(18.0).build();
        Product product24 = Product.builder().id(UUID.randomUUID()).name("Organic Almond Butter").description("340g jar, 100% pure roasted almonds, no added sugar").price(14.99).category(Category.FOOD.toString()).stock(90.0).build();
        Product product25 = Product.builder().id(UUID.randomUUID()).name("Vans Old Skool").description("Classic skate shoes, suede and canvas upper, waffle outsole").price(59.99).category(Category.FOOTWEAR.toString()).stock(80.0).build();
        Product product26 = Product.builder().id(UUID.randomUUID()).name("Nothing Phone (2)").description("6.7-inch OLED, Snapdragon 8+ Gen 1, 256GB, Glyph Interface").price(699.00).category(Category.MOBILE.toString()).stock(38.0).build();
        Product product27 = Product.builder().id(UUID.randomUUID()).name("Microsoft Surface Laptop Studio 2").description("14.4-inch touchscreen, Intel Core i7, RTX 4060, 32GB RAM").price(2499.99).category(Category.COMPUTERS.toString()).stock(12.0).build();
        Product product28 = Product.builder().id(UUID.randomUUID()).name("Aged Parmigiano Reggiano").description("24-month aged, 500g wedge, DOP certified from Italy").price(22.99).category(Category.FOOD.toString()).stock(65.0).build();
        Product product29 = Product.builder().id(UUID.randomUUID()).name("ASICS Gel-Kayano 30").description("Stability running shoes, FF BLAST PLUS ECO foam, 4D guidance").price(159.99).category(Category.FOOTWEAR.toString()).stock(42.0).build();
        Product product30 = Product.builder().id(UUID.randomUUID()).name("Motorola Edge 40 Pro").description("6.67-inch pOLED, Snapdragon 8 Gen 2, 256GB, 125W charging").price(799.99).category(Category.MOBILE.toString()).stock(30.0).build();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);
        productList.add(product11);
        productList.add(product12);
        productList.add(product13);
        productList.add(product14);
        productList.add(product15);
        productList.add(product16);
        productList.add(product17);
        productList.add(product18);
        productList.add(product19);
        productList.add(product20);
        productList.add(product21);
        productList.add(product22);
        productList.add(product23);
        productList.add(product24);
        productList.add(product25);
        productList.add(product26);
        productList.add(product27);
        productList.add(product28);
        productList.add(product29);
        productList.add(product30);
    }

    public ResponseEntity<PageResponse<ProductResponseDTO>> getProducts(int page, int limit, String sortBy, String direction, String search, Double minPrice, Double maxPrice) {
        log.info("=== GET PRODUCTS REQUEST ===");
        log.info("Raw params - page: {}, limit: {}, sortBy: '{}', direction: '{}', search: '{}', minPrice: {}, maxPrice: {}",
                page, limit, sortBy, direction, search, minPrice, maxPrice);

        if (page < 0) {
            log.warn("Page {} is negative, resetting to 0", page);
            page = 0;
        }
        if (limit < 1) {
            log.warn("Limit {} is invalid, resetting to 10", limit);
            limit = paginationProperties.getDefaultSize();
        }
        if (limit > paginationProperties.getMaxSize()) {
            log.warn("Limit {} exceeds max {}, capping to {}", limit, paginationProperties.getMaxSize(), paginationProperties.getMaxSize());
            limit = paginationProperties.getMaxSize();
        }
        log.info("After validation - page: {}, limit: {}", page, limit);

        // FILTER
        List<Product> filtered = productList.stream()
                .filter(p -> {
                    boolean match = search == null || search.isBlank() || p.getName().toLowerCase().contains(search.toLowerCase());
                    if (!match) log.debug("FILTERED OUT by search: {}", p.getName());
                    return match;
                })
                .filter(p -> {
                    boolean match = minPrice == null || p.getPrice() >= minPrice;
                    if (!match) log.debug("FILTERED OUT by minPrice: {} < {}", p.getName(), minPrice);
                    return match;
                })
                .filter(p -> {
                    boolean match = maxPrice == null || p.getPrice() <= maxPrice;
                    if (!match) log.debug("FILTERED OUT by maxPrice: {} > {}", p.getName(), maxPrice);
                    return match;
                })
                .toList();

        log.info("Filter result: {} of {} products match", filtered.size(), productList.size());

        int totalElements = filtered.size();
        int totalPages = (int) Math.ceil((double) totalElements / limit);
        log.info("Pagination meta - totalElements: {}, totalPages: {}", totalElements, totalPages);

        int start = page * limit;
        log.info("Calculated start: {} (page {} * limit {})", start, page, limit);

        if (start >= totalElements) {
            log.warn("Start {} >= totalElements {}, resetting to page 0", start, totalElements);
            start = 0;
            page = 0;
        }

        if (sortBy == null || sortBy.isBlank()) {
            log.info("sortBy is null/blank, defaulting to 'name'");
            sortBy = "name";
        }
        if (direction == null || direction.isBlank()) {
            log.info("direction is null/blank, defaulting to 'asc'");
            direction = "asc";
        }
        log.info("Final sort - sortBy: '{}', direction: '{}'", sortBy, direction);

        List<ProductResponseDTO> content = filtered.stream()
                .sorted(getComparator(sortBy, direction))
                .peek(p -> log.debug("After sort: {} - {}", p.getName(), p.getPrice()))
                .skip(start)
                .limit(limit)
                .peek(p -> log.debug("After pagination: {} - {}", p.getName(), p.getPrice()))
                .map(Product::toResponseDTO)
                .collect(Collectors.toList());

        log.info("Returning {} items for page {}", content.size(), page);

        PageResponse<ProductResponseDTO> response = new PageResponse<ProductResponseDTO>(
                content, page, limit, totalElements, totalPages,
                page > 0, page < totalPages - 1
        );

        log.info("=== RESPONSE === page: {}, size: {}, totalElements: {}, totalPages: {}, hasPrevious: {}, hasNext: {}",
                response.getPage(), response.getSize(), response.getTotalElements(),
                response.getTotalPages(), response.isHasPrevious(), response.isHasNext());

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ProductResponseDTO> getProductById(UUID productId) throws ProductNotFound {
        log.info("Fetching product with ID: {}", productId);
        Product product = productList.stream()
                .filter(product1 -> product1.getId().equals(productId))
                .findFirst().orElseThrow(() -> new ProductNotFound("Product Not Found of this product ID: " + productId));

        ProductResponseDTO productResponseDTO = product.toResponseDTO();

        log.info("Product found: {}", product.getName());
        return ResponseEntity.ok(productResponseDTO);
    }

    public List<ProductResponseDTO> getProductByCategory(String category) {
        log.info("Fetching products for category: {}", category);
        List<ProductResponseDTO> products = productList.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .map(Product::toResponseDTO)
                .collect(Collectors.toList());
        log.info("Found {} products in category '{}'", products.size(), category);
        return products;
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
        log.info("Adding new product: {}", productRequest.getName());

        // Optional: Check for duplicate name
        boolean exists = productList.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(productRequest.getName()));
        if (exists) {
            log.warn("Product with name '{}' already exists", productRequest.getName());
            throw new IllegalArgumentException("Product with this name already exists");
        }

        Product product = Product.builder()
                .id(UUID.randomUUID())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .stock(productRequest.getStock())
                .build();

        productList.add(product);
        log.info("Product added with ID: {}", product.getId());

        return product.toResponseDTO();
    }

    public ProductResponseDTO updateProduct(UUID productId, @Valid ProductRequestDTO productRequest) throws ProductNotFound {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        log.info("Updating product: {}", productId);

        Product existingProduct = productList.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> {
                    log.warn("Product not found for update: {}", productId);
                    return new ProductNotFound("Product not found with id: " + productId);
                });

        // Only update non-null fields (partial update support)
        if (productRequest.getName() != null) existingProduct.setName(productRequest.getName());
        if (productRequest.getDescription() != null) existingProduct.setDescription(productRequest.getDescription());
        if (productRequest.getPrice() != null) existingProduct.setPrice(productRequest.getPrice());
        if (productRequest.getCategory() != null) existingProduct.setCategory(productRequest.getCategory());
        if (productRequest.getStock() != null) existingProduct.setStock(productRequest.getStock());

        log.info("Product updated: {}", existingProduct.getName());
        return existingProduct.toResponseDTO();
    }

    private Comparator<Product> getComparator(String sortBy, String direction) {
        String field = (sortBy != null) ? sortBy.toLowerCase().trim() : "name";
        String dir = (direction != null) ? direction.toLowerCase().trim() : "asc";

        Comparator<Product> comparator = switch (field) {
            case "price" -> Comparator.comparing(Product::getPrice);
            case "category" -> Comparator.comparing(Product::getCategory);
            default -> Comparator.comparing(Product::getName);
        };

        if (dir.equals("desc")) {
            comparator = comparator.reversed();
        }

        return comparator;
    }
}
