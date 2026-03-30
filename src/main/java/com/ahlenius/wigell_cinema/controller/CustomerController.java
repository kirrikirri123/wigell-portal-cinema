package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.customerDto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @PostMapping("customers/{customerId}/addresses")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AddressResponse> addNewCostumerAddress(@PathVariable("customerId") Long id, @RequestBody CreateAddressDto dto) {
        return null;
    }

    @DeleteMapping("customers/{customerId}/addresses/{addressId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCustomerAddressById(@PathVariable("customerId") Long customerId, @PathVariable("addressId") Long addressId) {
        return null;
    }

    @GetMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<CustomerResponse> getCustomers() {
        return null;
    }

    @PostMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CreateCustomerDto dto) {
        return null;
    }

    @DeleteMapping("customers/{customerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") Long id) {
        return ResponseBody.noContent.build();
    }

    @PutMapping("customers/{customerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("customerId") Long id, @RequestBody UpdateCustomerDto dto) {
        return null;
    }

}
