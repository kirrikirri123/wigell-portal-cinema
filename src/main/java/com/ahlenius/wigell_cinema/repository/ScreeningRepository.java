package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening,Long> {
}
