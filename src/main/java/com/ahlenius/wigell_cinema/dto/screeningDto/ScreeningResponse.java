package com.ahlenius.wigell_cinema.dto.screeningDto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ScreeningResponse(
        Long id,
        Long movieId,
        Long roomId,
        LocalDate date,
        LocalTime time

) {

}
