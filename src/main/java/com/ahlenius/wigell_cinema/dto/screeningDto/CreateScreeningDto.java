package com.ahlenius.wigell_cinema.dto.screeningDto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record CreateScreeningDto(
        @NotNull
        Long movieId,
        @NotNull
        Long roomId,
        @FutureOrPresent(message = "Datum måste vara i framtiden.")
        LocalDate date,
        @NotNull(message = "Välj en starttid för visningen.")
        LocalTime time
) {
}
