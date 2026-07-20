package org.products.entities;

import lombok.*;
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
}
