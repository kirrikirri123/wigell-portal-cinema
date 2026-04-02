package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.ticketDto.CreateTicketDto;
import com.ahlenius.wigell_cinema.dto.ticketDto.TicketResponse;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class TicketController {

    @PostMapping("/tickets")
   // @PreAuthorize("hasRole('USER')")
    public ResponseEntity<TicketResponse> createTicket(@RequestBody CreateTicketDto dto) {
        return null;
    }

    @GetMapping("/tickets?customerId={customerId}")
   // @PreAuthorize("hasRole('USER')")
    public List<TicketResponse> findTicketsByCustomerId(@RequestParam String customerId) {
        //Se biljetter
        return null;
    }

}
