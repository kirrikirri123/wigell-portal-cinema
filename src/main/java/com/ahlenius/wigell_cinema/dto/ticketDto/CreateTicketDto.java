package com.ahlenius.wigell_cinema.dto.ticketDto;


import jakarta.validation.constraints.NotNull;

public record CreateTicketDto(
        @NotNull
        Long screeningId,
        @NotNull
        Long customerId
) {
}
