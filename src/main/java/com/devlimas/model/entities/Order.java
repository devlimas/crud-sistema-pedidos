package com.devlimas.model.entities;

import com.devlimas.model.enums.OrderStatus;
import com.devlimas.model.enums.Payment;
import jakarta.persistence.*;
import lombok.*;
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
@Table(name = "customer_orders")
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    @Id
    @ToString.Include
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @ToString.Include
    private LocalDate orderDate;

    @Column(nullable = false, precision = 10, scale = 2)
    @ToString.Include
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ToString.Include
    private OrderStatus orderStatus = OrderStatus.PROCESSING;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ToString.Include
    private Payment payment = Payment.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false) //nome do atributo+_id
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
    }

    @PrePersist
    @PreUpdate
    public void recalculateTotalAmount(){
        this.total = items.stream().map(OrderItem::getTotalValue).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addOrderItem(OrderItem item){
        items.add(item);
        item.setOrder(this);
    }

    public void removeOrderItem(OrderItem item){
        items.remove(item);
        item.setOrder(null);
    }
}
