package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findAddressByCustomerId(Long customerId);
}

