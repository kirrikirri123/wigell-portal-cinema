package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.movieDto.CreateMovieDto;
import com.ahlenius.wigell_cinema.dto.movieDto.MovieResponse;
import com.ahlenius.wigell_cinema.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

     private MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public MovieResponse save(CreateMovieDto dto) {
        //toEntity
        return null;
    }


}
