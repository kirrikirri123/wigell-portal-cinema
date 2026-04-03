package com.ahlenius.wigell_cinema.dto.customerDto;

public record AddressResponse(Long id,Long customerId, String street, String zipcode,String city) {
}
