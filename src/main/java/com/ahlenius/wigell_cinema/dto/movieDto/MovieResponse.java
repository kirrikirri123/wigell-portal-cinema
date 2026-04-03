package com.ahlenius.wigell_cinema.dto.movieDto;

import com.ahlenius.wigell_cinema.model.AgeLimit;
import com.ahlenius.wigell_cinema.model.Genre;

public record MovieResponse(Long id,String title, Genre genre, int durationMin, AgeLimit ageLimit) {
}
