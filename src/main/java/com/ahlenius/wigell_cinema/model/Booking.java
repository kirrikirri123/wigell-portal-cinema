package com.ahlenius.wigell_cinema.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "customer_id")
    private Customer customer;
    private int attendees;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "room_id")
    private Room room;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_id")
    private Movie movie;
    @Column(nullable = false)
    private boolean privateSpeaker; // hur ska man lägga upp detta? Vore av fördel att ha en vari
    @Column(name = "total_price_SEK",length = 50, nullable = false)
    private double totalPriceSEK; // sett detta utifrån attendees och movie/privateSpeeker
    @Column(name= "total_price_USD",length = 50, nullable = false)
    private double totalPriceUSD; // sett detta med hjälp av converterfunction.

    protected Booking() {}
 // test ! Sätter via hjälpmetoder efteråt mapping?
    public Booking(int attendees, LocalDate date, LocalTime time, boolean privateSpeaker) {
        this.attendees = attendees;
        this.date = date;
        this.time = time;
        this.privateSpeaker = privateSpeaker;
    }

    // sätter pris efteråt!
    public Booking(Customer customer, int attendees, Room room, LocalDate date, LocalTime time, Movie movie, boolean privateSpeaker) {
        this.customer = customer;
        this.attendees = attendees;
        this.room = room;
        this.date = date;
        this.time = time;
        this.movie = movie;
        this.privateSpeaker = privateSpeaker;
    }
 //konstruktor utan movie pga. kanske bara har en egen talare.
    public Booking(Customer customer, int attendees, Room room, LocalDate date, LocalTime time, boolean privateSpeaker) {
        this.customer = customer;
        this.attendees = attendees;
        this.room = room;
        this.date = date;
        this.time = time;
        this.privateSpeaker = privateSpeaker;
    }

    public Long getId() {
        return id;
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

    public boolean isPrivateSpeaker() {
        return privateSpeaker;
    }

    public void setPrivateSpeaker(boolean privateSpeaker) {
        this.privateSpeaker = privateSpeaker;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
