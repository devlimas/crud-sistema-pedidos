package com.devlimas.dto.OrderDto;

import com.devlimas.model.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record OrderUpdateDTO(
    @NotNull(message = "Status is required.")
    OrderStatus orderStatus
)
{
}
