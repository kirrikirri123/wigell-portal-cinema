package com.ahlenius.wigell_cinema.dto.screeningDto;

import java.time.LocalDateTime;

public record ScreeningResponse(
        Long id,
        Long movieId,
        Long roomId,
        LocalDateTime dateTime
) {

}
