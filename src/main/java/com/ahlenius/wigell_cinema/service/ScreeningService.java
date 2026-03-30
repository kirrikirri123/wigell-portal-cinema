package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

@Service
public class ScreeningService {

    private final ScreeningRepository repo;

    public ScreeningService(ScreeningRepository repo) {
        this.repo = repo;
    }
}
