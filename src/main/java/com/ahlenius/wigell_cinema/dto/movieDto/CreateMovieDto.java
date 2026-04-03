package com.ahlenius.wigell_cinema.dto.movieDto;

import com.ahlenius.wigell_cinema.model.AgeLimit;
import com.ahlenius.wigell_cinema.model.Genre;
import jakarta.validation.constraints.*;

public record CreateMovieDto(
        @NotBlank @Size(min =2 , max=50) String title,
        @NotNull Genre genre,
        @NotNull @Min(5)@Max(360) int durationMin,
        @NotNull AgeLimit ageLimit

) {
}
