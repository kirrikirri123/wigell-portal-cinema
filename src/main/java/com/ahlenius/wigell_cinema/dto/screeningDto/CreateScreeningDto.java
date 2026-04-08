package com.ahlenius.wigell_cinema.dto.screeningDto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateScreeningDto(
        @NotNull
        Long movieId,
        @NotNull
        Long roomId,
        @NotNull
        LocalDateTime dateTime
) {
}
