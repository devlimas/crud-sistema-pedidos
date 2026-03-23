package com.devlimas.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "products")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @ToString.Include
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 100)
    @ToString.Include
    private String productName;

    @Column(nullable = false, precision = 10, scale = 2)
    @ToString.Include
    private BigDecimal price;

    public Product() {
    }

    public Product(String productName, BigDecimal price) {
        this.productName = productName;
        this.price = price;
    }
}
