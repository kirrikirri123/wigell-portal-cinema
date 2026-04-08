package com.ahlenius.wigell_cinema.mapper;

import com.ahlenius.wigell_cinema.dto.bookingDto.CreateBookingDto;
import com.ahlenius.wigell_cinema.dto.screeningDto.CreateScreeningDto;
import com.ahlenius.wigell_cinema.dto.screeningDto.ScreeningResponse;
import com.ahlenius.wigell_cinema.model.*;

public class ScreeningMapper {

    private ScreeningMapper() {}


        public ScreeningResponse toDto(Screening s) {
            return new ScreeningResponse(
                    s.getId(),
                    s.getMovie().getId(),
                    s.getRoom().getId(),
                    s.getDateTime());
        }

        public static Screening toEntity(CreateScreeningDto dto, Room room, Movie movie) {
            return new Screening(
                    movie,
                    room,
                    dto.dateTime());}

        public static Screening toEntity(CreateScreeningDto dto) {
            return new Screening(dto.dateTime());

        }



    }

