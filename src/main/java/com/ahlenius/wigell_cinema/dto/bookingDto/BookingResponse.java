package com.ahlenius.wigell_cinema.dto.bookingDto;

import com.ahlenius.wigell_cinema.model.Movie;
import com.ahlenius.wigell_cinema.model.Room;

import java.time.LocalDate;
import java.time.LocalTime;

public record BookingResponse(Long id, int attendees, Room room, LocalDate date, LocalTime time, Movie movie, boolean privateSpeaker, double totalPriceSEK, double totalPriceUSD) {
}
