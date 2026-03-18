package com.devlimas.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "pedidos")
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedido {

    @Id
    @ToString.Include
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @ToString.Include
    private LocalDate dataDoPedido;

    @Column(nullable = false, precision = 10, scale = 2)
    @ToString.Include
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false) //nome do atributo+_id
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void recalcularValorTotal(){
        this.total = itens.stream().map(ItemPedido::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void adicionarItemPedido(ItemPedido item){
        itens.add(item);
        item.setPedido(this);
    }

    public void removeItemPedido(ItemPedido item){
        itens.remove(item);
        item.setPedido(null);
    }
}
