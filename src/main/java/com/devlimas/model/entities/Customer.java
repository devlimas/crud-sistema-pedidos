package com.devlimas.model.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "customers")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @ToString.Include
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @ToString.Include
    private String name;

    @Column(nullable = false ,length = 11, unique = true)
    private String cpf;

    @Column(nullable = false)
    @ToString.Include
    private LocalDate birthDate;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //O mapeamento usa de referencia o nome do atributo Customer na classe Order
    private List<Order> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String cpf, LocalDate birthDate) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public void addOrder(Order order){
        orders.add(order);
        order.setCustomer(this);
    }
}
