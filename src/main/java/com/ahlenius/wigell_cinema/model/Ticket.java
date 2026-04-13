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
    private final String ticketNr = UUID.randomUUID().toString();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="screening_id")
    private Screening screening;
    @Column(name = "total_price_SEK",length = 15)
    private  BigDecimal totalPriceSEK;
    @Column(name= "total_price_USD",length = 15)
    private BigDecimal totalPriceUSD;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "customer_id")
    private Customer customer;

    protected Ticket() {}

    public Ticket(Screening screening, Customer customer) {
        this.screening = screening;
        this.customer = customer;
        this.totalPriceSEK = BigDecimal.valueOf(85); // Just nu alltid samma pris.
        this.totalPriceUSD = getTotalPriceUSD() ;
    }

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

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public String getTicketNr() {
        return ticketNr;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Customer getCustomer() {
        return customer;
    }

    public Long getId() {
        return id;
    }
}
