package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.bookingDto.BookingResponse;
import com.ahlenius.wigell_cinema.dto.bookingDto.PatchBookingDto;
import com.ahlenius.wigell_cinema.dto.bookingDto.ReserveBookingDto;

import java.util.List;

public interface BookingService {
    BookingResponse saveBooking(ReserveBookingDto dto);
    BookingResponse patchBooking(Long id, PatchBookingDto dto);
    List<BookingResponse> findBookingsByCustomerId(Long id);

}
