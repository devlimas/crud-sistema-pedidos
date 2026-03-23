package com.devlimas.dto.OrderDto;

import com.devlimas.dto.OrderItemDto.OrderItemResponseDTO;
import com.devlimas.model.entities.Order;
import com.devlimas.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record OrderResponseDTO(
    Long id,
    Long customerId,
    String nameCustomer,
    LocalDate orderDate,
    OrderStatus orderStatus,
    BigDecimal total,
    List<OrderItemResponseDTO> items
)
{
    public static OrderResponseDTO from(Order order){
        return new OrderResponseDTO(
            order.getId(),
            order.getCustomer().getId(),
            order.getCustomer().getName(),
            order.getOrderDate(),
            order.getOrderStatus(),
            order.getTotal(),
            order.getItems().stream().map(OrderItemResponseDTO::from).toList()
        );
    }

}
