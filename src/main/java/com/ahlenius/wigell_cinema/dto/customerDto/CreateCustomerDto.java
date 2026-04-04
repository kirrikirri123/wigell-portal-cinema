package com.ahlenius.wigell_cinema.dto.customerDto;


public record CreateCustomerDto(
        String firstName,
        String lastName,
        String email,
        String phone,
        String username) {
}
