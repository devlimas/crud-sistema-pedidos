package com.devlimas.dto.OrderItemDto;

import com.devlimas.model.entities.OrderItem;

import java.math.BigDecimal;

public record OrderItemResponseDTO(
    Long id,
    Integer quantity,
    BigDecimal totalValue,
    Long orderId,
    Long productId
)
{
    public static OrderItemResponseDTO from (OrderItem orderItem){
        return new OrderItemResponseDTO(
                orderItem.getId(),
                orderItem.getQuantity(),
                orderItem.getTotalValue(),
                orderItem.getOrder().getId(),
                orderItem.getProduct().getId()
        );
    }
}
