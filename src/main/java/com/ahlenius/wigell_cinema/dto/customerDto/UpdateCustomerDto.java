package com.ahlenius.wigell_cinema.dto.customerDto;

import com.ahlenius.wigell_cinema.model.Address;

public record UpdateCustomerDto(String firstName, String lastName, Address address, String username) {
}
