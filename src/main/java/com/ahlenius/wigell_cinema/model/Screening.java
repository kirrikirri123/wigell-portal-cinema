package com.ahlenius.wigell_cinema.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "movie_id") // varje screening måste ha en film men en movie behöver inte ha en screening.
    private Movie movie;
    @OneToOne(mappedBy = "room_id") // behöver rummet veta att det har en screening?
    private Room room;
    private LocalDateTime dateTime;

    public Screening() {}

    public Screening(Movie movie, Room room, LocalDateTime dateTime) {
        this.movie = movie;
        this.room = room;
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
