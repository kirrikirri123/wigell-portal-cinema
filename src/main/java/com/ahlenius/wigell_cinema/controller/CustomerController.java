package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.customerDto.*;
import com.ahlenius.wigell_cinema.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    // här läggs http statuskoder!
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customers")
   // @PreAuthorize("hasRole('ADMIN')")
    public List<CustomerResponse> findAllCustomers() {
        return service.findAllCustomer();
    }

    @PostMapping("/customers")
 //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CreateCustomerDto dto) {
        var saved = service.createCustomer(dto);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.id()).toUri();
        return ResponseEntity.created(location).body(saved);}

    @PutMapping("customers/{customerId}")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("customerId") Long id, @RequestBody @Valid UpdateCustomerDto dto) {
       CustomerResponse updated = service.updateCustomer(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("customers/{customerId}")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("customers/{customerId}/addresses")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AddressResponse> addNewCostumerAddress(@PathVariable("customerId") Long id, @RequestBody @Valid CreateAddressDto dto) {
        AddressResponse response = service.addAddressToCostumerId(id,dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response); }

    @DeleteMapping("customers/{customerId}/addresses/{addressId}")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCustomerAddressById(@PathVariable("customerId") Long customerId, @PathVariable("addressId") Long addressId) {
        service.deleteAddressByCustomerId(customerId, addressId);
        return ResponseEntity.noContent().build();
    }

}
