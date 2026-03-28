package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.model.Screening;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AdminController {

    @GetMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Customer> getCustomers() {
        return null;
    } //Lista kunder GET /api/v1/customers

    @PostMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<CustomerDto> createCustomer() {
        return null; //Lägga till kund POST /api/v1/customers
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<Void> deleteCustomer(@RequestBody Long id) {
        return ResponseBody.noContent.build();//Ta bort kund DELETE /api/v1/customers/{customerId}
    }

    @PutMapping("/api/v1/customers/{customerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<CustomerDto> updateCustomer(@RequestBody UpdateCustomerDto dto) {
        return null;//Uppdatera kund
    }

    @GetMapping("/movies")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<MovieDto> createMovie(@RequestBody CreateMovieDto dto) {
        return null;
        //Lägga till film
    }

    @DeleteMapping("/movies/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<Void> deleteMovie(@Value("{movieId}") Long id) {
        return null;
        //Ta bort film DELETE /api/v1/movies/{movieId}
    }

    @GetMapping("/rooms")
    @PreAuthorize("hasRole('ADMIN')")
    public List<RoomDto> findAllRooms() {
        return null;
        //Lista lokaler
    }

    @GetMapping("rooms/{roomId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<RoomDto> findRoomById(@Value("{roomId}") Long id) {
        return null;
//Hämta lokal GET /api/v1/rooms/{roomId}
    }

    @PutMapping("/rooms")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<RoomDto> createRoom(@RequestBody CreateRoomDto dto) {
        return null;
        //Lägg till lokal POST /api/v1/rooms
    }

    @PutMapping("/rooms/{roomId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<RoomDto> updateRoom(@Value("{roomId}") Long id, @RequestBody UpdateRoomDto dto) {
        return null;
//  Uppdatera lokal PUT /api/v1/rooms/{roomId}
    }
/*
@GetMapping("/movies")
@PreAuthorize("hasRole('ADMIN')")
//Lista filmer GET /api/v1/movies
Ligger i customerController */


    @GetMapping("/movies/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<MovieDto> findMovieById(@Value("{movieId}") Long id) {
        return null;
        // Hämta film
    }

    @GetMapping("/screening")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ScreeningDto> findAllScreenings() {
        return null;
        //Lista föreställningar GET /api/v1/screenings
    }

    @PostMapping("/screening")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<ScreeningDto> createScreening(@RequestBody CreateScreeningDto dto) {
        return null;
    }

    @DeleteMapping("/screenings/{screeningId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<Void> deleteScreening(@Value("{screeningId}") Long id) {
        return null;
    }

    @PostMapping("customers/{customerId}/addresses")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<AddressDto> addNewCostumerAddress(@RequestBody CreateAddressDto dto) {
        return null;
    }

    @DeleteMapping("customers/{customerId}/addresses/{addressId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<Void> deleteCustomerAddressById(@Value("{customerId}") Long custId, @Value("{addressId}") Long adrId) {
        return null;
    }

}
