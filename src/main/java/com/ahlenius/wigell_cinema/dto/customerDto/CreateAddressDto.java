package com.ahlenius.wigell_cinema.dto.customerDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAddressDto(
        @NotBlank @Size(min= 5,max = 15) String street,
        @NotBlank @Size(min= 5, max =10)String zipcode,
        @NotBlank String city) {
}
