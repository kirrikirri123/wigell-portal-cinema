package com.ahlenius.wigell_cinema.repository;

import com.ahlenius.wigell_cinema.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
