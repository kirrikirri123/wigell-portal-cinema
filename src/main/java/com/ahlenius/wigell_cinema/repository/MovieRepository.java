package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
