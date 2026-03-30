package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.customerDto.*;
import com.ahlenius.wigell_cinema.exception.NoSuchMemberFoundException;
import com.ahlenius.wigell_cinema.mapper.CustomerMapper;
import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;

    public CustomerServiceImpl(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponse> findAllCustomer() {
            return repo.findAll().stream()
                    .map(CustomerMapper::toDto)
                    .toList();
    }

    @Override
    @Transactional
    public CustomerResponse createCustomer(CreateCustomerDto dto) {
        //Lägg till nått exceptions!
        Customer newCustomer = CustomerMapper.toEntity(dto);
         return CustomerMapper.toDto(repo.save(newCustomer));
    }

    @Override
    @Transactional
    public CustomerResponse updateCustomer(Long id, UpdateCustomerDto dto) {
        Customer found = repo.findById(id).orElseThrow(()-> new NoSuchMemberFoundException("Hittade ingen matchande kund med id: "+ id));
        Customer updated = CustomerMapper.applyUpdate(found,dto);
        return CustomerMapper.toDto(repo.save(updated));
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
    }

    @Override
    @Transactional
    public AddressResponse addAddressToCostumerId(Long id, CreateAddressDto dto) {
        return null;
    }

    @Override
    @Transactional
    public void deleteAddressByCustomerId(Long id) {
    }
}
