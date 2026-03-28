package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.model.Movie;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @GetMapping("/movies")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public List<Movie> getMovies() {
        return null;//Lista filmer
    }

    @GetMapping("/screenings?movieId={movieId}&date={YYYY-MM-DD}")
    @PreAuthorize("hasRole('USER')")
    public List<ScreeningDto> findScreeningsByDate() {
        return null;
        // Lista föreställningar
    }

    @PostMapping("/tickets")
    @PreAuthorize("hasRole('USER')")
    public ResponseBody<TicketDto> createTicket(@RequestBody CreateTicketDto dto) {
        return null;
    }

    @GetMapping("/tickets?customerId={customerId}")
    @PreAuthorize("hasRole('USER')")
    public List<TicketDto> findTicketsByCustomerId(@PathVariable("customerId") String customerId) {
        //Se biljetter
        return null;
    }

// RUMSBOKNINGAR

    @PostMapping("/bookings")
    @PreAuthorize("hasRole('USER')")
    public ResponseBody<BookingDto> reserveRoom(@RequestBody ReserveBookingDto dto) {
        // Reservera lokaal
        return null;
    }

    @PatchMapping("/bookings?customerId={customerId}")
    public ResponseBody<BookingDto> patchBooking(@RequestBody patchBookingDto) {
        return null;
        //Uppdatera bokning PATCH /api/v1/bookings/{bookingId} (tillåtna fält: datum, teknisk utrustning) Uppdatera rumsbokning
    }


    @GetMapping("/api/v1/bookings?customerId={customerId}")
    @PreAuthorize("hasRole('USER')")
    public List<BookingDto> findBookingsByCustomerId(@PathVariable("customerId") String customerId) {
        //Se tidigare och aktiva bokningar GET /api/v1/bookings?customerId={customerId}
        return null;
    }


}
