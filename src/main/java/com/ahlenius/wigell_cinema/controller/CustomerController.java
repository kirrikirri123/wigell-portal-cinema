package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.model.Customer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @PostMapping("customers/{customerId}/addresses")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<AddressDto> addNewCostumerAddress(@PathVariable("customerId") Long id, @RequestBody CreateAddressDto dto) {
        return null;
    }

    @DeleteMapping("customers/{customerId}/addresses/{addressId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<Void> deleteCustomerAddressById(@PathVariable("customerId") Long customerId, @PathVariable("addressId") Long addressId) {
        return null;
    }

    @GetMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Customer> getCustomers() {
        return null;
    } //Lista kunder GET /api/v1/customers

    @PostMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<CustomerDto> createCustomer(@RequestBody CreateCustomerDto dto) {
        return null; //Lägga till kund POST /api/v1/customers
    }

    @DeleteMapping("customers/{customerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<Void> deleteCustomer(@PathVariable("customerId") Long id) {
        return ResponseBody.noContent.build();//Ta bort kund DELETE /api/v1/customers/{customerId}
    }

    @PutMapping("customers/{customerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<CustomerDto> updateCustomer(@PathVariable("customerId") Long id, @RequestBody UpdateCustomerDto dto) {
        return null;//Uppdatera kund
    }

}
