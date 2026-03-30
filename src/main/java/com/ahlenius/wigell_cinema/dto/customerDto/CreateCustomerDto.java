package com.ahlenius.wigell_cinema.dto.customerDto;


public record CreateCustomerDto(String firstName, String lastName, AddressResponse addr,String email,String phone, String username) {
}
