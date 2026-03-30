package com.ahlenius.wigell_cinema.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int attendees;
    @OneToOne(mappedBy = "room_id")  //En bokning ett rum, behöver rummet veta om bokningen?
    private Room room;
    private LocalDateTime date;
    @OneToOne(mappedBy = "movie_id") // Lägg in en NoShow i databasen?
    private Movie movie;
    @Column(nullable = false)
    private boolean privateSpeaker; // hur ska man lägga upp detta? Vore av fördel att ha en vari
    @Column(name = "total_price_SEK",length = 50, nullable = false)
    private double totalPriceSEK; // sett detta utifrån attendees och movie/privateSpeeker
    @Column(name= "total_price_USD",length = 50, nullable = false)
    private double totalPriceUSD; // sett detta med hjälp av converterfunction.

    protected Booking() {}

    public Booking(int attendees, Room room, LocalDateTime date, Movie movie, boolean privateSpeaker, double totalPriceSEK, double totalPriceUSD) {
        this.attendees = attendees;
        this.room = room;
        this.date = date;
        this.movie = movie;
        this.privateSpeaker = privateSpeaker;
        this.totalPriceSEK = totalPriceSEK;
        this.totalPriceUSD = totalPriceUSD;
    }

    public Booking(int attendees, Room room, LocalDateTime date, Movie movie, boolean privateSpeaker) {
        this.attendees = attendees;
        this.room = room;
        this.date = date;
        this.movie = movie;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
}
