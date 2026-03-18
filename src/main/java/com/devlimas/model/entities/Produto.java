package com.devlimas.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter

@Entity
@Table(name = "produtos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {

    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto", nullable = false, length = 100)
    private String nomeProduto;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    public Produto() {
    }

    public Produto(String nomeProduto, BigDecimal preco) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }
}
