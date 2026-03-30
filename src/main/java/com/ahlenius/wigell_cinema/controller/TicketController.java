package com.ahlenius.wigell_cinema.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class TicketController {

    @PostMapping("/tickets")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<TicketDto> createTicket(@RequestBody CreateTicketDto dto) {
        return null;
    }

    @GetMapping("/tickets?customerId={customerId}")
    @PreAuthorize("hasRole('USER')")
    public List<TicketDto> findTicketsByCustomerId(@PathVariable("customerId") String customerId) {
        //Se biljetter
        return null;
    }

}
