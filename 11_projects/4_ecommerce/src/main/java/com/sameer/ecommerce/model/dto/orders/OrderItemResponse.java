package com.sameer.ecommerce.model.dto.orders;

import java.math.BigDecimal;

public record OrderItemResponse(String productName, int quantity, BigDecimal totalPrice) {
}
