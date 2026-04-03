package com.ahlenius.wigell_cinema.dto.customerDto;


public record CustomerResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String username) {
}
