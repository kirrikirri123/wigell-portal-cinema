package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository repo;

    public TicketService(TicketRepository repo) {
        this.repo = repo;    }


}
