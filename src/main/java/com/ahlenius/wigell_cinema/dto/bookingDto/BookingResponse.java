package com.ahlenius.wigell_cinema.dto.bookingDto;


import java.time.LocalDate;
import java.time.LocalTime;

public record BookingResponse(
        Long id,
        Long customerId,
        String customerName,
        int attendees,
        Long roomId,
        String roomName,
        LocalDate date,
        LocalTime time,
        Long movieId,
        boolean privateSpeaker,
        double totalPriceSEK,
        double totalPriceUSD) {
}
