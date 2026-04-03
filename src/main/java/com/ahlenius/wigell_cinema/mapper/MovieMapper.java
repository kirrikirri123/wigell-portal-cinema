package com.ahlenius.wigell_cinema.mapper;

import com.ahlenius.wigell_cinema.dto.movieDto.CreateMovieDto;
import com.ahlenius.wigell_cinema.dto.movieDto.MovieResponse;
import com.ahlenius.wigell_cinema.model.Movie;

public class MovieMapper {

    private MovieMapper() {
    }

    public static MovieResponse toDto(Movie m) {
        return new MovieResponse(m.getId(), m.getTitle(), m.getGenre(), m.getDurationMin(), m.getAgeLimit());
    }

    public static Movie toEntity(CreateMovieDto dto) {
        return new Movie(dto.title(),dto.genre(),dto.durationMin(),dto.ageLimit());
    }


}
