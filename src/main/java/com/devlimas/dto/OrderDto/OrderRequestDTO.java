package com.devlimas.dto.OrderDto;

import jakarta.validation.constraints.NotNull;

public record OrderRequestDTO(
    @NotNull(message = "Customer is required.")
    Long customerId
)
{
}
