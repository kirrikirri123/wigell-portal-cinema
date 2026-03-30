package com.ahlenius.wigell_cinema.dto.customerDto;

public record UpdateCustomerDto(String firstName, String lastName, CreateAddressDto addr,String email,String phone, String username) {
}
