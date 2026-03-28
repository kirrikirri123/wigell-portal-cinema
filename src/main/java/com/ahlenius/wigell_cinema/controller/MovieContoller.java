package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.model.Movie;
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
    public ResponseBody<MovieDto> createMovie(@RequestBody CreateMovieDto dto) {
        return null;
        //Lägga till film
    }

    @DeleteMapping("/movies/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<Void> deleteMovie(@PathVariable("movieId") Long id) {
        return null;
        //Ta bort film DELETE /api/v1/movies/{movieId}
    }
    @GetMapping("/movies/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<MovieDto> findMovieById(@PathVariable("movieId") Long id) {
        return null;
        // Hämta film
    }
}
