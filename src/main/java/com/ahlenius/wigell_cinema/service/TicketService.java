package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.ticketDto.CreateTicketDto;
import com.ahlenius.wigell_cinema.dto.ticketDto.TicketResponse;
import com.ahlenius.wigell_cinema.mapper.TicketMapper;
import com.ahlenius.wigell_cinema.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository repo;

    public TicketService(TicketRepository repo) {
        this.repo = repo;    }


    @Transactional
    public TicketResponse saveTicket(CreateTicketDto dto) {

        return null;
    }

    @Transactional
    public List<TicketResponse> customerTickets(Long  customerId) {
        return repo.findTicketByCustomerId(customerId).stream()
                .map(TicketMapper::toDto)
                .toList();
        
    }

}
