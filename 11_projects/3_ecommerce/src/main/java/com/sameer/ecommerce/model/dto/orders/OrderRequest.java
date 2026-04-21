package com.sameer.ecommerce.model.dto.orders;

import java.util.List;

public record OrderRequest(String customerName, String email, List<OrderItemRequest> items) {
}
