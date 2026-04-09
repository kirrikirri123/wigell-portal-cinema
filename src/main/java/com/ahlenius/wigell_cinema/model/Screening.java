package com.ahlenius.wigell_cinema.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="movie_id")
    private Movie movie;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="room_id")
    private Room room;
    private LocalDate date;
    private LocalTime time;
    @OneToMany(mappedBy = "screening", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Ticket> ticketsList = new ArrayList<>();

    public Screening() {}

    public Screening(Movie movie, Room room, LocalDate date, LocalTime time) {
        this.movie = movie;
        this.room = room;
        this.date = date;
        this.time = time;
    }

    public Screening(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public void addTicket(Ticket ticket) {
        ticketsList.add(ticket);
        ticket.setScreening(this);
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

    public Long getId() {
        return id; }

    public Movie getMovie() {
        return movie;}

    public void setMovie(Movie movie) {
        this.movie = movie;}

    public Room getRoom() {
        return room;}

    public void setRoom(Room room) {
        this.room = room;}

}
