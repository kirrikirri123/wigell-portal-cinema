package com.ahlenius.wigell_cinema.dto.movieDto;

import com.ahlenius.wigell_cinema.model.AgeLimit;
import com.ahlenius.wigell_cinema.model.Genre;
import jakarta.validation.constraints.*;

public record CreateMovieDto(
        @NotBlank(message = "Titel behöve anges.")
        @Size(min = 2, max = 50)
        String title,
        @NotNull(message = "Ange en genre")
        Genre genre,
        @NotNull(message = "Filmens längd behöver registreras.")
        @Min(5) @Max(360)
        int durationMin,
        @NotNull(message = "Ange åldersgräns.")
        AgeLimit ageLimit

) {
}
