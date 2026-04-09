package com.ahlenius.wigell_cinema.mapper;


import com.ahlenius.wigell_cinema.dto.screeningDto.CreateScreeningDto;
import com.ahlenius.wigell_cinema.dto.screeningDto.ScreeningResponse;
import com.ahlenius.wigell_cinema.model.*;

public class ScreeningMapper {

    private ScreeningMapper() {
    }


    public static ScreeningResponse toDto(Screening s) {
        return new ScreeningResponse(
                s.getId(),
                s.getMovie().getId(),
                s.getRoom().getId(),
                s.getDate(),
                s.getTime());
    }

    public static Screening toEntity(CreateScreeningDto dto, Room room, Movie movie) {
        return new Screening(
                movie,
                room,
                dto.date(),
                dto.time()
        );
    }

    public static Screening toEntity(CreateScreeningDto dto) {
        return new Screening(dto.date(),dto.time());

    }


}

