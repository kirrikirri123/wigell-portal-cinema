package com.ahlenius.wigell_cinema.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ScreeningController {

    @GetMapping("/screenings?movieId={movieId}&date={YYYY-MM-DD}")
    @PreAuthorize("hasRole('USER')")
    public List<ScreeningDto> findScreeningsByDate(@PathVariable("movieId") Long movieId,@RequestBody DateDto dto) {
        return null;
        // Lista föreställningar
    }

    @GetMapping("/screening")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ScreeningDto> findAllScreenings() {
        return null;
        //Lista föreställningar GET /api/v1/screenings
    }

    @PostMapping("/screening")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<ScreeningDto> createScreening(@RequestBody CreateScreeningDto dto) {
        return null;
    }

    @DeleteMapping("/screenings/{screeningId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody<Void> deleteScreening(@PathVariable("screeningId") Long id) {
        return null;
    }
}
