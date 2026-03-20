package com.devlimas.dto.CustomerDto;

import com.devlimas.model.entities.Customer;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CustomerRequestDTO(
    @NotBlank(message = "The name is required and cannot be empty.")
    @Size(min = 3, max = 20, message = "The name must have a minimum of 3 characters and a maximum of 20.")
    String name,

    @NotBlank(message = "The CPF is required and cannot be empty.")
    @Pattern(regexp = "\\d{11}", message = "CPF must have 11 numeric digits.")
    String cpf,

    @NotNull(message = "The birth date is required.")
    @Past(message = "The birth date must be a date in the past.")
    LocalDate birthDate

)
{
    public Customer toEntity(){
        return new Customer(name, cpf, birthDate);
    }
}
