package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
