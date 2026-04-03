package com.ahlenius.wigell_cinema.dto.bookingDto;

import com.ahlenius.wigell_cinema.dto.movieDto.MovieResponse;
import com.ahlenius.wigell_cinema.dto.roomDto.RoomResponse;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReserveBookingDto(
        @Min(1) @Max(3) int attendees,
        @Min(1) Long customerId,
        @Min(1) Long roomId,
        @NotNull(message = "Önskat datum behövs för bokning.")
        @FutureOrPresent(message = "Valt datum har redan passerat.")
        LocalDate date,
        @NotNull(message = "Önskad tid behöver anges.")
        LocalTime time,
        Long movieId,
        @NotBlank boolean privateSpeaker) {
}
