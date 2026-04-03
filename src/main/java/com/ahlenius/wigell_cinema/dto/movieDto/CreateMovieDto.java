package com.ahlenius.wigell_cinema.dto.movieDto;

import com.ahlenius.wigell_cinema.model.AgeLimit;
import com.ahlenius.wigell_cinema.model.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateMovieDto(
        @NotBlank @Size(min =2 , max=50) String title,
        @NotBlank @Size(max=15) Genre genre,
        @NotBlank @Min(5)@Max(360) int durationMin,
        @NotBlank @Size(max = 7)AgeLimit ageLimit

) {
}
