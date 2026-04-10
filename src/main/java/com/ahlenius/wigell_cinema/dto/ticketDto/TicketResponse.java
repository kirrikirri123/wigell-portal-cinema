package com.ahlenius.wigell_cinema.dto.ticketDto;
import java.math.BigDecimal;


public record TicketResponse(
        Long id,
        String ticketNr,
        Long screeningId,
        String movie,
        String startTime,
        BigDecimal totalPriceSEK,
        BigDecimal totalPriceUSD,
        String customerFname) {
}
