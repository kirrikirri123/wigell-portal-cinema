package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
