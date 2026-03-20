package com.devlimas.dto.OrderItemDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemRequestDTO(
        @NotNull(message = "Quantity is required.")
        @Positive(message = "Quantity must be greater than zero.")
        Integer quantity,
        @NotNull(message = "Order is required.")
        Long orderId,
        @NotNull(message = "Product is required.")
        Long productId
)
{
}
