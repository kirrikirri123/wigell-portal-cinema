package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository repo;

    public RoomService(RoomRepository repo) {
        this.repo = repo;
    }
}
