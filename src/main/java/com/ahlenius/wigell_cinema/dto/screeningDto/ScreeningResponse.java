package com.ahlenius.wigell_cinema.dto.screeningDto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ScreeningResponse(
        Long id,
        Long movieId,
        String movieTitle,
        Long roomId,
        String roomName,
        LocalDate date,
        LocalTime startTime

) {

}
