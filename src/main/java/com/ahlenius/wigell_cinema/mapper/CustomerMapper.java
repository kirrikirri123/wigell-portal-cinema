package com.ahlenius.wigell_cinema.mapper;

import com.ahlenius.wigell_cinema.dto.customerDto.*;
import com.ahlenius.wigell_cinema.model.Address;
import com.ahlenius.wigell_cinema.model.Customer;

public class CustomerMapper {

    private CustomerMapper() {
    }

    public static CustomerResponse toDto(Customer c) {
                return new CustomerResponse(c.getId(), c.getFirstName(),c.getLastName(),c.getEmail(), c.getPhone(),c.getUsername());
    }

    public static AddressResponse toDto(Address a) {
        return new AddressResponse(a.getId(),a.getCustomer().getId(),a.getStreet(),a.getZipcode(),a.getCity());
    }

    public static Customer toEntity(CreateCustomerDto dto) {
    return new Customer(dto.firstName(), dto.lastName(),dto.email(), dto.phone(), dto.username());
    }

    public static Address toAddressEntity(CreateAddressDto dto){
        return new Address(dto.street(),dto.zipcode(),dto.city());
    }

    public static Customer applyUpdate(Customer c, UpdateCustomerDto dto) {
        c.setFirstName(dto.firstName());
        c.setLastName(dto.lastName());;
        c.setEmail(dto.email());
        c.setPhone(dto.phone());
        c.setUsername(dto.username());
        return c;
    }

}
