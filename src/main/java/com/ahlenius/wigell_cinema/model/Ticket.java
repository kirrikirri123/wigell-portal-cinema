package com.ahlenius.wigell_cinema.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(,unique = true)
    private String ticketNr = UUID.randomUUID().toString();
    @OneToOne
    private Screening screening;
    @Column(name = "total_price_SEK",length = 50, nullable = false) // alltid samma pris
    private double totalPriceSEK; // sett detta utifrån attendees och movie/privateSpeeker
    @Column(name= "total_price_USD",length = 50, nullable = false) // alltid samma pris
    private double totalPriceUSD; // sett detta med hjälp av converterfunction.

    protected Ticket() {}

    public Ticket(Screening screening) {
        this.screening = screening;
    }

    public double getTotalPriceUSD() {
        return totalPriceUSD;
    }

    public void setTotalPriceUSD(double totalPriceUSD) {
        this.totalPriceUSD = totalPriceUSD;
    }

    public double getTotalPriceSEK() {
        return totalPriceSEK;
    }

    public void setTotalPriceSEK(double totalPriceSEK) {
        this.totalPriceSEK = totalPriceSEK;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public String getTicketNr() {
        return ticketNr;
    }

    public void setTicketNr(String ticketNr) {
        this.ticketNr = ticketNr;
    }
}
