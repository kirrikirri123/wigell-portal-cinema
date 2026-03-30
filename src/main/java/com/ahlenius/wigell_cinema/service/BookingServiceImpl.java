package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl {

    private final BookingRepository repo;

    public BookingServiceImpl(BookingRepository repo) {
        this.repo = repo;
    }
}
