package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.ticketDto.CreateTicketDto;
import com.ahlenius.wigell_cinema.dto.ticketDto.TicketResponse;
import com.ahlenius.wigell_cinema.exception.NoCustomerFoundException;
import com.ahlenius.wigell_cinema.exception.NoScreeningFoundException;
import com.ahlenius.wigell_cinema.mapper.TicketMapper;
import com.ahlenius.wigell_cinema.model.Ticket;
import com.ahlenius.wigell_cinema.repository.CustomerRepository;
import com.ahlenius.wigell_cinema.repository.ScreeningRepository;
import com.ahlenius.wigell_cinema.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TicketService {

    private static final Logger log = LoggerFactory.getLogger(TicketService.class);
    private final TicketRepository repo;
    private final ScreeningRepository sRepo;
    private final CustomerRepository cRepo;
    private final PricingService pricingService;

    public TicketService(TicketRepository repo, ScreeningRepository sRepo, CustomerRepository cRepo, PricingService pricingService) {
        this.repo = repo;
        this.sRepo = sRepo;
        this.cRepo = cRepo;
        this.pricingService = pricingService;
    }

    @Transactional
    public TicketResponse saveTicket(CreateTicketDto dto) {
        var screening = sRepo.findById(dto.screeningId()).orElseThrow(()-> new NoScreeningFoundException("Hittade ingen matchande visning."));
        var customer =  cRepo.findById(dto.customerId()).orElseThrow(()-> new NoCustomerFoundException("Ingen matchande kund."));
        //Entitys Skapas
           Ticket ticket = TicketMapper.toEntity(screening,customer);
           pricingService.setTicketPrice(ticket);
           screening.addTicket(ticket);
           customer.addTicket(ticket);
                repo.save(ticket); // Här sparar vi mot databas och får id.
            log.info("Biljett skapad med ID: {}", ticket.getId());
        return TicketMapper.toDto(ticket);
    }

    @Transactional
    public List<TicketResponse> customerTickets(Long  customerId) {
        return repo.findTicketByCustomerId(customerId).stream()
                .map(TicketMapper::toDto)
                .toList();
    }

}
