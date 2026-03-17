package com.devlimas.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter

@Entity
@Table(name = "clientes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataAniversario;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //O mapeamento usa de referencia o nome do atributo Cliente na classe Pedido
    private List<Pedido> pedidos = new ArrayList<>();
}
