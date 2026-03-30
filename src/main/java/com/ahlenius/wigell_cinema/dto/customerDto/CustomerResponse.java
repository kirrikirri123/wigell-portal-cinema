package com.ahlenius.wigell_cinema.dto.customerDto;


public record CustomerResponse(Long id,String firstName, String lastName, AddressResponse addr,String email,String phone, String username) {
}
