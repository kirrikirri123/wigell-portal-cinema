package com.ahlenius.wigell_cinema.controller;

import com.ahlenius.wigell_cinema.dto.screeningDto.CreateScreeningDto;
import com.ahlenius.wigell_cinema.dto.screeningDto.ScreeningResponse;
import com.ahlenius.wigell_cinema.service.ScreeningService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ScreeningController {

    private final ScreeningService service;

    public ScreeningController(ScreeningService service) {
        this.service = service;
    }

    @GetMapping(value = "/screenings", params ={"movieId","date"})
 //   @PreAuthorize("hasRole('USER')")
    public List<ScreeningResponse> findScreeningsByDate(@RequestParam Long movieId, @RequestParam LocalDate date) {
        return service.findAllScreeningsByDate(movieId,date);
    }
    @GetMapping("/screenings")
  //  @PreAuthorize("hasRole('ADMIN')")
    public List<ScreeningResponse> findAllScreenings() {
        return service.findAllScreenings();
    }

    @PostMapping("/screenings")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ScreeningResponse> createScreening(@RequestBody @Valid CreateScreeningDto dto) {
        var saved = service.saveScreening(dto);
        var uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.id()).toUri();
        return ResponseEntity.created(uriLocation).body(saved);
    }

    @DeleteMapping("/screenings/{screeningId}")
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteScreening(@PathVariable("screeningId") Long id) {
        service.deleteScreening(id);
        return ResponseEntity.noContent().build();
    }
}
