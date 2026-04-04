package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.bookingDto.BookingResponse;
import com.ahlenius.wigell_cinema.dto.bookingDto.PatchBookingDto;
import com.ahlenius.wigell_cinema.dto.bookingDto.CreateBookingDto;
import com.ahlenius.wigell_cinema.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping("/bookings")
    //  @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookingResponse> reserveRoom(@RequestBody @Valid CreateBookingDto dto) {
        var saved = service.saveBooking(dto);
        var uriLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.id())
                .toUri();
        return ResponseEntity.created(uriLocation).body(saved);
    }

    @PatchMapping("/bookings/{bookingId}")
    public ResponseEntity<BookingResponse> patchBooking(@PathVariable Long id, @RequestBody @Valid PatchBookingDto dto) {
        return null;
        //(tillåtna fält: datum, teknisk utrustning) Uppdatera rumsreservering
    }

    @GetMapping("/bookings?customerId={customerId}")
    // @PreAuthorize("hasRole('USER')")
    public List<BookingResponse> findBookingsByCustomerId(@RequestParam Long customerId) {
         return service.findBookingsByCustomerId(customerId);
    }

    // Extra metod för egen testnings skull.
    @GetMapping("/bookings")
    // @PreAuthorize("hasRole('USER')")
    public List<BookingResponse> findAllBookings() {
        return service.findALlBookings();
    }

}
