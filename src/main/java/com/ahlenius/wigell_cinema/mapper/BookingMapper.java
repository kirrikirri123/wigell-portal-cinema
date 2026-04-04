package com.ahlenius.wigell_cinema.mapper;

import com.ahlenius.wigell_cinema.dto.bookingDto.BookingResponse;
import com.ahlenius.wigell_cinema.dto.bookingDto.CreateBookingDto;
import com.ahlenius.wigell_cinema.model.Booking;


public class BookingMapper {

    private BookingMapper() {
    }

    public static BookingResponse toDto(Booking b) {
        return new BookingResponse(b.getId(),
                b.getCustomer().getId(),
                b.getAttendees(),
                b.getRoom().getId(),
                b.getDate(),
                b.getTime(),
                b.getMovie().getId(),
                b.isPrivateSpeaker(),
                b.getTotalPriceSEK(),
                b.getTotalPriceUSD());
    }

    public static Booking toEntity(CreateBookingDto dto) {
        return new Booking(dto.attendees(),
                dto.customerId(),
                dto.roomId(),
                dto.date(),
                dto.time(),
                dto.movieId(),
                dto.privateSpeaker());
    }

}
