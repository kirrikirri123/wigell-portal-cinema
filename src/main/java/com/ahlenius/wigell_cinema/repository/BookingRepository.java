package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Booking;
import com.ahlenius.wigell_cinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    Optional<Booking> findMovieById(long id);
}
