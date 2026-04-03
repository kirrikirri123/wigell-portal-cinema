package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.bookingDto.BookingResponse;
import com.ahlenius.wigell_cinema.dto.bookingDto.PatchBookingDto;
import com.ahlenius.wigell_cinema.dto.bookingDto.ReserveBookingDto;
import com.ahlenius.wigell_cinema.mapper.BookingMapper;
import com.ahlenius.wigell_cinema.model.Booking;
import com.ahlenius.wigell_cinema.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repo;

    public BookingServiceImpl(BookingRepository repo) {
        this.repo = repo;
    }

    //int attendees, Room room, LocalDate date,LocalTime time, Movie movie, boolean privateSpeaker

    @Override
    public BookingResponse saveBooking(ReserveBookingDto dto) {
        
         repo.save();
        return null;
    }

    @Override
    public BookingResponse patchBooking(Long id, PatchBookingDto dto) {
        return null;
    }

    @Override
    public List<BookingResponse> findBookingsByCustomerId(Long id) {

        return List.of();
    }
}
