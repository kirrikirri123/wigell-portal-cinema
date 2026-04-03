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
    @Column(name = "genre",length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(name= "duration_min",length = 5)
    private int durationMin;
    @Column(length = 7, nullable = false)
    @Enumerated(EnumType.STRING)
    private AgeLimit ageLimit;

    public Movie(String title, Genre genre, int durationMin, AgeLimit ageLimit) {
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

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }
}
