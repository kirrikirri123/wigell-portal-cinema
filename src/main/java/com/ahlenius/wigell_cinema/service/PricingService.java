package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.model.Booking;
import com.ahlenius.wigell_cinema.model.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;


@Service
public class PricingService {

    private final WebClient converterClient;
    private final String PATH = "/api/currency/rate";

    public PricingService(WebClient converterClient) {
        this.converterClient = converterClient;
    }

    public BigDecimal getRate(String from, String to){
        return converterClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(PATH)
                        .queryParam("from", from)
                        .queryParam("to",to)
                        .build())
                .retrieve()
                .bodyToMono(BigDecimal.class)
                .block();
    }

    public void setTicketPrice(Ticket ticket) {
        BigDecimal rate = getRate("SEK","USD");
        ticket.setTotalPriceUSD(ticket.getTotalPriceSEK().multiply(rate));

    }

    public void setBookingPrice(Booking booking) {
        BigDecimal rate = getRate("SEK","USD");
        BigDecimal additionalCosts = BigDecimal.valueOf(1700); // Här ingår rummet + film
        if(booking.isPrivateSpeaker() && booking.getMovie().getTitle().equals("NO MOVIE")){
            additionalCosts = BigDecimal.valueOf(1500); // -200 extra om bara egen talare
        } else if(booking.isPrivateSpeaker() && !booking.getMovie().getTitle().equals("NO MOVIE")){
            additionalCosts = BigDecimal.valueOf(2500);} // extra om egentalare  + film
        BigDecimal totalPriceAttendees = BigDecimal.valueOf(booking.getAttendees()).multiply(BigDecimal.valueOf(35));
        BigDecimal totalSEK = totalPriceAttendees.add(additionalCosts);
        booking.setTotalPriceSEK(totalSEK);
        booking.setTotalPriceUSD(booking.getTotalPriceSEK().multiply(rate));
    }


}
