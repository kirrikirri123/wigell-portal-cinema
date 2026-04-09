package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Movie;
import com.ahlenius.wigell_cinema.model.Room;
import com.ahlenius.wigell_cinema.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening,Long> {
    List<Screening> findByMovieAndDateEquals(Movie movie, LocalDate date);

}
