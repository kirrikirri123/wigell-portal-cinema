package com.ahlenius.wigell_cinema.mapper;

import com.ahlenius.wigell_cinema.dto.customerDto.AddressResponse;
import com.ahlenius.wigell_cinema.dto.customerDto.CreateCustomerDto;
import com.ahlenius.wigell_cinema.dto.customerDto.CustomerResponse;
import com.ahlenius.wigell_cinema.dto.customerDto.UpdateCustomerDto;
import com.ahlenius.wigell_cinema.model.Address;
import com.ahlenius.wigell_cinema.model.Customer;

public class CustomerMapper {

    private CustomerMapper() {
    }

    public static CustomerResponse toDto(Customer c) {
        AddressResponse addressDto = new AddressResponse(c.getAddress().getId(), c.getAddress().getStreet(),c.getAddress().getZipcode(), c.getAddress().getCity());
        return new CustomerResponse(c.getId(), c.getFirstName(),c.getLastName(),addressDto, c.getEmail(), c.getPhone(),c.getUsername());
    }

    public static Customer toEntity(CreateCustomerDto dto) {
    return new Customer(dto.firstName(), dto.lastName(),
            new Address(dto.addr().street(),dto.addr().zipcode(),dto.addr().city()),
            dto.email(), dto.phone(), dto.username());

    }
    public static Customer applyUpdate(Customer c, UpdateCustomerDto dto) {
        c.setFirstName(dto.firstName());
        c.setLastName(dto.lastName());
        c.setAddress(new Address(dto.addr().street(),dto.addr().zipcode(),dto.addr().city()));
        c.setEmail(dto.email());
        c.setPhone(dto.phone());
        c.setUsername(dto.username());
        return c;
    }

}
