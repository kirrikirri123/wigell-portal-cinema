package com.ahlenius.wigell_cinema.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="movie_id")
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="room_id")
    private Room room;
    private LocalDateTime dateTime;

    public Screening() {}

    public Screening(Movie movie, Room room, LocalDateTime dateTime) {
        this.movie = movie;
        this.room = room;
        this.dateTime = dateTime;
    }
//movie och room sätts genom hjälp metoder?
    public Screening(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;}

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;}
}
