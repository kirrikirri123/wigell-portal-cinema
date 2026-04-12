package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.customerDto.*;
import com.ahlenius.wigell_cinema.exception.NoMatchingAddressIdException;
import com.ahlenius.wigell_cinema.exception.NoCustomerFoundException;
import com.ahlenius.wigell_cinema.mapper.CustomerMapper;
import com.ahlenius.wigell_cinema.model.Address;
import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.repository.AddressRepository;
import com.ahlenius.wigell_cinema.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
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
        Customer newCustomer = CustomerMapper.toEntity(dto);
        Customer saved = repo.save(newCustomer);
        log.info("Kund skapad med ID: {} ", newCustomer.getId());
         return CustomerMapper.toDto(saved);
    }

    @Override
    @Transactional
    public CustomerResponse updateCustomer(Long id, UpdateCustomerDto dto) {
        var found = repo.findById(id).orElseThrow(() -> new NoCustomerFoundException("Hittade ingen matchande kund med id: " + id));
        Customer updated = CustomerMapper.applyUpdate(found, dto);
        Customer saved = repo.save(updated);
        log.debug("Kund med ID: {} är uppdaterad", updated.getId());
        return CustomerMapper.toDto(saved);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        if (!repo.existsById(id)) {
            throw new NoCustomerFoundException("Hittade ingen matchande kund med id: " + id);
        }
        repo.deleteById(id);
        log.info("Kund med ID: {} är borttaget framgångsrikt ", id);
    }
    @Override
    @Transactional
    public AddressResponse addAddressToCostumerId(Long id, CreateAddressDto dto) {
        var found = repo.findById(id).orElseThrow(() -> new NoCustomerFoundException("Hittade ingen matchande kund med id: " + id));
        // Här borde man dra en dubbel koll ifall adressen redan ligger inlagd på kunden så den inte läggs dubbelt.
        Address address = CustomerMapper.toAddressEntity(dto);
        found.addAddress(address);// Lägger i listan och sätter kunden på adressen.
        addressRepo.save(address);
        log.info("Address skapad med ID: {} ", address.getId());
        repo.save(found);
        log.info("Kund med ID: {} har sparats adress med ID: {} ", id,address.getId());
        return CustomerMapper.toDto(address);
    }

    @Override
    @Transactional
    public void deleteAddressByCustomerId(Long customerId, Long addressId) {
        var found = repo.findById(customerId).orElseThrow(() -> new NoCustomerFoundException("Hittade ingen matchande kund med id: " + customerId));

         Address address = found.getAddressList().stream().filter(a -> a.getId().equals(addressId))
                        .findFirst().orElseThrow(() -> new NoMatchingAddressIdException("Ingen adress med id: " + addressId + " hos kund med id: " + customerId));
        addressRepo.delete(address);// ADRESS FINNS KVAR efter 201 no content.
        log.info("Address med ID: {} hos Kund med ID: {} togs bort.",addressId,customerId);
        repo.save(found);
    }

    @Override
    public List<AddressResponse> findAddressByCustomerId(Long customerId) {
        return addressRepo.findAddressByCustomerId(customerId).stream()
                .map(CustomerMapper::toDto)
                .toList();
    }
}
