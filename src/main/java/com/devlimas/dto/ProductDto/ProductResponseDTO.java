package com.devlimas.dto.ProductDto;

import com.devlimas.model.entities.Product;

import java.math.BigDecimal;

public record ProductResponseDTO(
    Long id,
    String productName,
    BigDecimal price

)
{
    public static ProductResponseDTO from (Product product){
        return new ProductResponseDTO(
            product.getId(),
            product.getProductName(),
            product.getPrice()
        );
    }
}
