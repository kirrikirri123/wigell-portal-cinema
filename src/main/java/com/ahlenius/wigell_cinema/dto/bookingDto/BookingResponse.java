package com.ahlenius.wigell_cinema.dto.bookingDto;


import java.time.LocalDate;
import java.time.LocalTime;

public record BookingResponse(
        Long id,
        Long customerId,
        int attendees,
        Long roomId,
        LocalDate date,
        LocalTime time,
        Long movieId,
        boolean privateSpeaker,
        double totalPriceSEK,
        double totalPriceUSD) {
}
