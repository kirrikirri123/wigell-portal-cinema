package com.ahlenius.wigell_cinema.dto.bookingDto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateBookingDto(
        @Min(2) @Max(245) int attendees,
        @Min(1) Long customerId,
        @Min(1) Long roomId,
        @NotNull(message = "Önskat datum behövs för bokning.")
        @FutureOrPresent(message = "Valt datum har redan passerat.")
        LocalDate date,
        @NotNull(message = "Önskad tid behöver anges.")
        LocalTime time,
        @NotNull(message = "Sätt filmID nr. 6 om du önskar boka utan filmvisning.")
        Long movieId,// Om man inte vill ha en filmvisning sätter man noMovie alternativet - 6 .
        boolean privateSpeaker) {
}
