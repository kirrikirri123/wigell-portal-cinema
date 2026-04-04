package com.ahlenius.wigell_cinema.mapper;

import com.ahlenius.wigell_cinema.dto.bookingDto.BookingResponse;
import com.ahlenius.wigell_cinema.dto.bookingDto.CreateBookingDto;
import com.ahlenius.wigell_cinema.model.Booking;
import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.model.Movie;
import com.ahlenius.wigell_cinema.model.Room;


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

    public static Booking toEntity(CreateBookingDto dto, Customer customer, Room room,Movie movie) {
        return new Booking(
                customer,
                dto.attendees(),
                room,
                dto.date(),
                dto.time(),
                movie,
                dto.privateSpeaker());
    }

    public static Booking toEntity(CreateBookingDto dto) {
        return new Booking(
                dto.attendees(),
                dto.date(),
                dto.time(),
                dto.privateSpeaker());
    }

}
