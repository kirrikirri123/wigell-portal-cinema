package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.screeningDto.CreateScreeningDto;
import com.ahlenius.wigell_cinema.dto.screeningDto.ScreeningResponse;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ScreeningController {

    @GetMapping("/screenings?movieId={movieId}&date={YYYY-MM-DD}")
 //   @PreAuthorize("hasRole('USER')")
    public List<ScreeningResponse> findScreeningsByDate(@PathVariable("movieId") Long movieId, @PathVariable LocalDateTime date) {
        return null;
        // Lista föreställningar
    }

    @GetMapping("/screening")
  //  @PreAuthorize("hasRole('ADMIN')")
    public List<ScreeningResponse> findAllScreenings() {
        return null;
        //Lista föreställningar GET /api/v1/screenings
    }

    @PostMapping("/screening")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ScreeningResponse> createScreening(@RequestBody CreateScreeningDto dto) {
        return null;
    }

    @DeleteMapping("/screenings/{screeningId}")
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteScreening(@PathVariable("screeningId") Long id) {
        return null;
    }
}
