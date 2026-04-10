package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
        List<Ticket> findTicketByCustomerId(Long customerId);
}
