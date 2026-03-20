package com.devlimas.dto.ProductDto;

import com.devlimas.model.entities.Product;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductRequestDTO(
    @NotBlank(message = "Empty or null values are not allowed.")
    @Size(min = 3, max = 20, message = "The product name must have a minimum of 3 characters and a maximum of 20.")
    String productName,

    @Positive(message = "The price must be greater than zero.")
    @NotNull(message = "Price is required.")
    BigDecimal price
)
{
    public Product toEntity() {
        return new Product(productName, price);
    }
}

