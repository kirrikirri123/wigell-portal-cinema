package com.ahlenius.wigell_cinema.dto.customerDto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateCustomerDto(
        @NotBlank(message = "Ange förnamn.")
        String firstName,
        @NotBlank(message = "Ange efternamn")
        String lastName,
        @NotBlank @Email(message = "Dubbelkolla mailadress.")
        String email,
        @NotBlank (message = "Ange telefonnummer")
        String phone,
        @NotBlank (message = "Bestäm ett användarnamn")
        String username) {
}
