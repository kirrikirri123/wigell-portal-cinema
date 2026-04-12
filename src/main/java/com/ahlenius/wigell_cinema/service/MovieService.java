package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.movieDto.CreateMovieDto;
import com.ahlenius.wigell_cinema.dto.movieDto.MovieResponse;
import com.ahlenius.wigell_cinema.exception.NoMovieFoundException;
import com.ahlenius.wigell_cinema.exception.NoCustomerFoundException;
import com.ahlenius.wigell_cinema.mapper.MovieMapper;
import com.ahlenius.wigell_cinema.model.Movie;
import com.ahlenius.wigell_cinema.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieService.class);
    private final MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public List<MovieResponse> findAll() {
        return repo.findAll().stream()
                .map(MovieMapper::toDto)
                .toList();}

    @Transactional
    public MovieResponse saveMovie(CreateMovieDto dto) {
        var movie = repo.save(MovieMapper.toEntity(dto));
        log.info("Film skapad med ID: {} ", movie.getId());
        return MovieMapper.toDto(movie);
    }

    @Transactional
    public void deleteMovie(Long id) {
        if (!repo.existsById(id)) {
            throw new NoCustomerFoundException("Hittade ingen film med id: " + id);
        }
        repo.deleteById(id);
        log.info("Film med ID: {} är borttagen framgångsrikt", id);
    }

    @Transactional
    public MovieResponse findMovieById(Long id) {
        var movie = repo.findById(id).orElseThrow(()->new NoMovieFoundException("Hittade ingen film med id: " + id));
        return MovieMapper.toDto(movie);
           }


    }
