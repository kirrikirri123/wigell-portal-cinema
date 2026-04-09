package com.ahlenius.wigell_cinema.dto.ticketDto;


import com.ahlenius.wigell_cinema.model.Customer;

import java.math.BigDecimal;

public record TicketResponse(
        Long id,
        String ticketNr,
        Long screeningId,
        BigDecimal totalPriceSEK,
        BigDecimal totalPriceUSD,
        Long customerId) {
}
