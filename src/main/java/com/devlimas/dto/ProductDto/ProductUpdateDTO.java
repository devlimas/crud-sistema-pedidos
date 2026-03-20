package com.devlimas.dto.ProductDto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductUpdateDTO(
        @Size(min = 3, max = 20, message = "The product name must have a minimum of 3 characters and a maximum of 20.")
        String productName,
        @Positive(message = "The price must be greater than zero.")
        BigDecimal price
)
{
}
