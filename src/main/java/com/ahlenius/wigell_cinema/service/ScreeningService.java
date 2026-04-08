package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.screeningDto.ScreeningResponse;
import com.ahlenius.wigell_cinema.exception.NoScreeningFoundException;
import com.ahlenius.wigell_cinema.mapper.ScreeningMapper;
import com.ahlenius.wigell_cinema.model.Screening;
import com.ahlenius.wigell_cinema.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    private final ScreeningRepository repo;

    public ScreeningService(ScreeningRepository repo) {
        this.repo = repo;
    }

    public List<ScreeningResponse> findAllScreenings() {
        return repo.findAll().stream()
                .map(ScreeningMapper::toDto)
                .toList();
    }

    public void deleteScreening(Long id) {
        if(!repo.existsById(id)){
            throw new NoScreeningFoundException("Hittade ingen visning med id: "+ id); }
        repo.deleteById(id);
    }


}

