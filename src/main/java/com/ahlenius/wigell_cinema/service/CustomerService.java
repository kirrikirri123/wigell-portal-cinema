package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.customerDto.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    CustomerResponse createCustomer(CreateCustomerDto dto);
    void deleteCustomer(Long id);
    CustomerResponse updateCustomer(Long id,UpdateCustomerDto dto);
    List<CustomerResponse> findAllCustomer();
    AddressResponse addAddressToCostumerId(Long id,CreateAddressDto dto);
    void deleteAddressByCustomerId(Long id);
}
