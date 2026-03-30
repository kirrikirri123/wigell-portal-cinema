package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.movieDto.CreateMovieDto;
import com.ahlenius.wigell_cinema.dto.movieDto.MovieDto;
import com.ahlenius.wigell_cinema.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieContoller {

    @GetMapping("/movies")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public List<Movie> getMovies() {
        return null;//Lista filmer
    }

    @GetMapping("/movies")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieDto> createMovie(@RequestBody CreateMovieDto dto) {
        return null;

    }

    @DeleteMapping("/movies/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMovie(@PathVariable("movieId") Long id) {
        return null;

    }
    @GetMapping("/movies/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieDto> findMovieById(@PathVariable("movieId") Long id) {
        return null;

    }
}
