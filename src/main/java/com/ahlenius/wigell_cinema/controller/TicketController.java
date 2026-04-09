package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.ticketDto.CreateTicketDto;
import com.ahlenius.wigell_cinema.dto.ticketDto.TicketResponse;
import com.ahlenius.wigell_cinema.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class TicketController {

    private final TicketService service;

     public TicketController(TicketService service) {
        this.service = service;
     }

    @PostMapping("/tickets")
   // @PreAuthorize("hasRole('USER')")
    public ResponseEntity<TicketResponse> createTicket(@RequestBody @Valid CreateTicketDto dto){
        var saved = service.saveTicket(dto);
        var uriLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.id()).toUri();
            return ResponseEntity.created(uriLocation).body(saved);
    }

    @GetMapping(value="/tickets", params ={"customerId"})
   // @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<TicketResponse>> findTicketsByCustomerId(@RequestParam Long customerId) {
         List <TicketResponse> tickets = service.customerTickets(customerId);
         return ResponseEntity.ok(tickets);
    }

}
