package com.devlimas.dto.CustomerDto;

import com.devlimas.dto.OrderDto.OrderResponseDTO;
import com.devlimas.model.entities.Customer;

import java.time.LocalDate;
import java.util.List;

public record CustomerResponseDTO(
    Long id,
    String name,
    String cpf,
    LocalDate birthDate,
    List<OrderResponseDTO> orders
)
{
    public static CustomerResponseDTO from(Customer customer){
        return new CustomerResponseDTO(
            customer.getId(),
            customer.getName(),
            customer.getCpf(),
            customer.getBirthDate(),
            customer.getOrders().stream().map(OrderResponseDTO::from).toList()
        );
    }
}
