package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.movieDto.CreateMovieDto;
import com.ahlenius.wigell_cinema.dto.movieDto.MovieResponse;
import com.ahlenius.wigell_cinema.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/movies")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public ResponseEntity<List<MovieResponse>> findAllMovies() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/movies")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieResponse> createMovie(@RequestBody @Valid CreateMovieDto dto) {
        var saved = service.saveMovie(dto);
        var uriLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.id()).toUri();
        return ResponseEntity.created(uriLocation).body(saved);
    }

    @DeleteMapping("/movies/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMovie(@PathVariable("movieId") Long id) {
        service.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/movies/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public MovieResponse findMovieById(@PathVariable("movieId") Long id) {
        return service.findMovieById(id);
    }
}
