package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.screeningDto.CreateScreeningDto;
import com.ahlenius.wigell_cinema.dto.screeningDto.ScreeningResponse;
import com.ahlenius.wigell_cinema.exception.NoMovieFoundException;
import com.ahlenius.wigell_cinema.exception.NoRoomFoundException;
import com.ahlenius.wigell_cinema.exception.NoScreeningFoundException;
import com.ahlenius.wigell_cinema.mapper.ScreeningMapper;
import com.ahlenius.wigell_cinema.model.Screening;
import com.ahlenius.wigell_cinema.repository.MovieRepository;
import com.ahlenius.wigell_cinema.repository.RoomRepository;
import com.ahlenius.wigell_cinema.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScreeningService {

    private final ScreeningRepository repo;
    private final MovieRepository mRepo;
    private final RoomRepository rRepo;


    public ScreeningService(ScreeningRepository repo, MovieRepository mRepo, RoomRepository rRepo) {
        this.repo = repo;
        this.mRepo = mRepo;
        this.rRepo = rRepo;
    }

    public List<ScreeningResponse> findAllScreeningsByDate(Long movieId, LocalDate date) {
        var movie = mRepo.findById(movieId).orElseThrow(()-> new NoMovieFoundException("Ingen film hittad med id: "+ movieId));
        List <Screening> sList = repo.findByMovieAndDateEquals(movie,date);
        if(sList.isEmpty()){ throw new NoScreeningFoundException("Hittade inga visningar "+ date + ", av "+ movie.getTitle());}

        return sList.stream()
            .map(ScreeningMapper::toDto)
            .toList();}

    public List<ScreeningResponse> findAllScreenings() {
        return repo.findAll().stream()
                .map(ScreeningMapper::toDto)
                .toList();
    }

    public ScreeningResponse saveScreening(CreateScreeningDto dto) {
        var room = rRepo.findById(dto.roomId()).orElseThrow(() -> new NoRoomFoundException("Inget matchande rum hittades."));
        var movie = mRepo.findById(dto.movieId()).orElseThrow(() -> new NoMovieFoundException("Ingen matchande film hittades."));
        Screening screening = ScreeningMapper.toEntity(dto);
        room.addScreening(screening);
        movie.addScreening(screening);

        return ScreeningMapper.toDto(repo.save(screening));
            }

    public void deleteScreening(Long id) {
        if(!repo.existsById(id)){
            throw new NoScreeningFoundException("Hittade ingen visning med id: "+ id); }
        repo.deleteById(id);
    }


}

