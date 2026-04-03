package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
