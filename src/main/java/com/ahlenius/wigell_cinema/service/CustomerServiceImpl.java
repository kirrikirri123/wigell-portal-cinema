package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.customerDto.*;
import com.ahlenius.wigell_cinema.exception.NoMatchingAddressIdException;
import com.ahlenius.wigell_cinema.exception.NoSuchMemberFoundException;
import com.ahlenius.wigell_cinema.mapper.CustomerMapper;
import com.ahlenius.wigell_cinema.model.Address;
import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.repository.AddressRepository;
import com.ahlenius.wigell_cinema.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;
    private final AddressRepository addressRepo;

    public CustomerServiceImpl(CustomerRepository repo, AddressRepository addressRepo) {
        this.repo = repo;
        this.addressRepo = addressRepo;
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
        Customer found = repo.findById(id).orElseThrow(() -> new NoSuchMemberFoundException("Hittade ingen matchande kund med id: " + id));
        Customer updated = CustomerMapper.applyUpdate(found, dto);
        return CustomerMapper.toDto(repo.save(updated));
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchMemberFoundException("Hittade ingen matchande kund med id: " + id);
        }
        repo.deleteById(id);
    }

    @Override
    @Transactional
    public AddressResponse addAddressToCostumerId(Long id, CreateAddressDto dto) {
        Customer found = repo.findById(id).orElseThrow(() -> new NoSuchMemberFoundException("Hittade ingen matchande kund med id: " + id));
        Address address = CustomerMapper.toAddressEntity(dto);
        address.setCustomer(found);
        addressRepo.save(address);
        repo.save(found);
        return CustomerMapper.toDto(address);
    }

    @Override
    @Transactional
    public void deleteAddressByCustomerId(Long customerId, Long addressId) {
        Customer found = repo.findById(customerId).orElseThrow(() -> new NoSuchMemberFoundException("Hittade ingen matchande kund med id: " + customerId));
        Address address = found.getAddressList().stream().filter(a -> a.getId().equals(addressId))
                        .findFirst().orElseThrow(() -> new NoMatchingAddressIdException("Ingen adress med id: " + addressId + " hos kund med id: " + customerId));
        addressRepo.delete(address);
    }
}
