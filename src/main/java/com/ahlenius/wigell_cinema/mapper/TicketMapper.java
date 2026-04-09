package com.ahlenius.wigell_cinema.mapper;


import com.ahlenius.wigell_cinema.dto.ticketDto.CreateTicketDto;
import com.ahlenius.wigell_cinema.dto.ticketDto.TicketResponse;
import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.model.Screening;
import com.ahlenius.wigell_cinema.model.Ticket;

public class TicketMapper {

    private TicketMapper() {}

    public static TicketResponse toDto(Ticket t) {
        return new TicketResponse(t.getId(),t.getTicketNr(),t.getScreening().getId(), t.getTotalPriceSEK(), t.getTotalPriceUSD(),t.getCustomer().getId());
    }

    public static Ticket toEntity(CreateTicketDto dto, Screening screening, Customer customer) {
         return new Ticket(screening,customer);
    }
}
