package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.movieDto.CreateMovieDto;
import com.ahlenius.wigell_cinema.dto.movieDto.MovieResponse;
import com.ahlenius.wigell_cinema.exception.ConflictException;
import com.ahlenius.wigell_cinema.exception.NoMovieFoundException;
import com.ahlenius.wigell_cinema.exception.NoCustomerFoundException;
import com.ahlenius.wigell_cinema.mapper.MovieMapper;
import com.ahlenius.wigell_cinema.repository.BookingRepository;
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
    private final BookingRepository bRepo ;

    public MovieService(MovieRepository repo, BookingRepository bRepo) {
        this.bRepo = bRepo;
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
            throw new NoCustomerFoundException("Hittade ingen film med id: " + id);}
        var foundBooking = bRepo.findMovieById(id).orElse(null);
        if(foundBooking != null) { throw new ConflictException("Kan ej ta bort film då den är kopplad mot bokning med ID: "+foundBooking.getId());
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
