package com.ahlenius.wigell_cinema.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 100)
    private String ticketNr = UUID.randomUUID().toString();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="screening_id")
    private Screening screening;
    @Column(name = "total_price_SEK",length = 15, nullable = false) // alltid samma pris
    private BigDecimal totalPriceSEK; // sett detta utifrån attendees och movie/privateSpeeker
    @Column(name= "total_price_USD",length = 15, nullable = false) // alltid samma pris
    private BigDecimal totalPriceUSD; // sett detta med hjälp av converterfunction.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "customer_id")
    private Customer customer;

    protected Ticket() {}

    public Ticket(Screening screening) {
        this.screening = screening;
    }

    public BigDecimal getTotalPriceUSD() {
        return totalPriceUSD;
    }

    public void setTotalPriceUSD(BigDecimal totalPriceUSD) {
        this.totalPriceUSD = totalPriceUSD;
    }

    public BigDecimal getTotalPriceSEK() {
        return totalPriceSEK;
    }

    public void setTotalPriceSEK(BigDecimal totalPriceSEK) {
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Customer getCustomer() {
        return customer;
    }
}
