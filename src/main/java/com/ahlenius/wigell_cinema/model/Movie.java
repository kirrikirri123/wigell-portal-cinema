package com.ahlenius.wigell_cinema.model;

import jakarta.persistence.*;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",length = 50, nullable = false)
    private String title;
    @Column(name = "genre",length = 10, nullable = false)
    private String genre; // ENUM?
    @Column(name= "duration_min",length = 50)
    private int durationMin;
    @Column(length = 2, nullable = false)
    private String ageLimit; //Enum

    public Movie(String title, String genre, int durationMin, String ageLimit) {
        this.title = title;
        this.genre = genre;
        this.durationMin = durationMin;
        this.ageLimit = ageLimit;
    }
    protected Movie() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }
}
