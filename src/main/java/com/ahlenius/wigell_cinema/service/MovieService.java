package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.movieDto.CreateMovieDto;
import com.ahlenius.wigell_cinema.dto.movieDto.MovieResponse;
import com.ahlenius.wigell_cinema.exception.NoMovieFoundException;
import com.ahlenius.wigell_cinema.exception.NoCustomerFoundException;
import com.ahlenius.wigell_cinema.mapper.MovieMapper;
import com.ahlenius.wigell_cinema.model.Movie;
import com.ahlenius.wigell_cinema.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MovieService {

    private MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public List<MovieResponse> findAll() {
        return repo.findAll().stream()
                .map(MovieMapper::toDto)
                .toList();
    }

    @Transactional
    public MovieResponse saveMovie(CreateMovieDto dto) {
        Movie movie = repo.save(MovieMapper.toEntity(dto));
        return MovieMapper.toDto(movie);
    }

    @Transactional
    public void deleteMovie(Long id) {
        if (!repo.existsById(id)) {
            throw new NoCustomerFoundException("Hittade ingen film med id: " + id);
        }
        repo.deleteById(id);
    }

    @Transactional
    public MovieResponse findMovieById(Long id) {
        Movie movie = repo.findById(id).orElseThrow(()->new NoMovieFoundException("Hittade ingen film med id: " + id));
        return MovieMapper.toDto(movie);
           }


    }
