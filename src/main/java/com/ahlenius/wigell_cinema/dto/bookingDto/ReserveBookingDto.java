package com.ahlenius.wigell_cinema.dto.bookingDto;

import com.ahlenius.wigell_cinema.dto.movieDto.MovieResponse;
import com.ahlenius.wigell_cinema.dto.roomDto.RoomResponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReserveBookingDto(
        @NotBlank @Size(max = 3) int attendees,
        RoomResponse roomDto,
        @NotBlank LocalDate date,
        @NotBlank LocalTime time,
        MovieResponse movieDto,
        @NotBlank boolean privateSpeaker) {
}
