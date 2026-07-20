package org.products.entities;

import lombok.*;
import org.products.Dtos.request.ProductRequestDTO;
import org.products.Dtos.response.ProductResponseDTO;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private double stock;

    // Convert from Request DTO to Entity
    public static Product fromRequestDTO(ProductRequestDTO requestDTO) {
        return Product.builder().name(requestDTO.getName()).description(requestDTO.getDescription())
                .price(requestDTO.getPrice())
                .category(requestDTO.getCategory())
                .stock(requestDTO.getStock())
                .build();
    }

    // Convert from Entity to Response DTO
    public ProductResponseDTO toResponseDTO() {
        return ProductResponseDTO.builder().id(this.id).name(this.name).description(this.description)
                .price(this.price)
                .category(this.category)
                .stock(this.stock)
                .build();
    }
}
