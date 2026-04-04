package com.ahlenius.wigell_cinema.dto.customerDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAddressDto(
        @NotBlank(message = "Gata behöver anges.")
        @Size(min = 5, max = 15)
        String street,
        @NotBlank(message = "Ange postkod, 5 siffror.")
        @Size(min = 5, max = 10)
        String zipcode,
        @NotBlank(message = "Stad behöver anges.")
        String city) {
}
