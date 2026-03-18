package com.devlimas.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "clientes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    @ToString.Include
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @ToString.Include
    private String nome;

    @Column(nullable = false ,length = 11, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataAniversario;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //O mapeamento usa de referencia o nome do atributo Cliente na classe Pedido
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, String cpf, LocalDate dataAniversario) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataAniversario = dataAniversario;
    }

    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
        pedido.setCliente(this);
    }
}
