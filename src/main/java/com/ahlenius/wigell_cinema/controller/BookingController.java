package com.ahlenius.wigell_cinema.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @PostMapping("/bookings")
    @PreAuthorize("hasRole('USER')")
    public ResponseBody<BookingDto> reserveRoom(@RequestBody ReserveBookingDto dto) {
        // Reservera lokal
        return null;
    }

    @PatchMapping("/bookings?customerId={customerId}")
    public ResponseBody<BookingDto> patchBooking(@PathVariable("customerId") @RequestBody patchBookingDto dto) {
        return null;
        //Uppdatera bokning PATCH /api/v1/bookings/{bookingId} (tillåtna fält: datum, teknisk utrustning) Uppdatera rumsreservering
    }

    @GetMapping("bookings?customerId={customerId}")
    @PreAuthorize("hasRole('USER')")
    public List<BookingDto> findBookingsByCustomerId(@PathVariable("customerId") Long customerId) {
        //Se tidigare och aktiva bokningar GET /api/v1/bookings?customerId={customerId}
        return null;
    }


}
