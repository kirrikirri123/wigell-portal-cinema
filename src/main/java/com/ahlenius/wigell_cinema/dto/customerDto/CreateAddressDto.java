package com.ahlenius.wigell_cinema.dto.customerDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAddressDto(
        @NotBlank @Size() String city,
        @NotBlank @Size() String zipcode,
        @NotBlank @Size() String street) {
}
