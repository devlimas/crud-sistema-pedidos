package com.devlimas.dto.CustomerDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CustomerUpdateDTO(
    @NotBlank(message = "The name is required and cannot be empty.")
    @Size(min = 3, max = 20, message = "The name must have a minimum of 3 characters and a maximum of 20.")
    String name,

    @Past(message = "The birth date must be a date in the past.")
    LocalDate birthDate
)
{
}
