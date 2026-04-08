package com.ahlenius.wigell_cinema.dto.bookingDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.FutureOrPresent;


import java.time.LocalDate;
import java.time.LocalTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PatchBookingDto (
        @FutureOrPresent(message = "Valt datum har redan passerat.")
        LocalDate date,
        LocalTime time
){
}
