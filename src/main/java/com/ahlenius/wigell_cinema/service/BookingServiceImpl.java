package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.bookingDto.BookingResponse;
import com.ahlenius.wigell_cinema.dto.bookingDto.PatchBookingDto;
import com.ahlenius.wigell_cinema.dto.bookingDto.CreateBookingDto;
import com.ahlenius.wigell_cinema.exception.*;
import com.ahlenius.wigell_cinema.mapper.BookingMapper;
import com.ahlenius.wigell_cinema.model.Booking;
import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.model.Movie;
import com.ahlenius.wigell_cinema.model.Room;
import com.ahlenius.wigell_cinema.repository.BookingRepository;
import com.ahlenius.wigell_cinema.repository.CustomerRepository;
import com.ahlenius.wigell_cinema.repository.MovieRepository;
import com.ahlenius.wigell_cinema.repository.RoomRepository;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private static final Logger log = LoggerFactory.getLogger(BookingServiceImpl.class);
    private final BookingRepository bRepo;
    private final CustomerRepository cRepo;
    private final MovieRepository mRepo;
    private final RoomRepository rRepo;
    //private final WebClient webClient;

    public BookingServiceImpl(BookingRepository bRepo, CustomerRepository cRepo, MovieRepository mRepo, RoomRepository rRepo) {
        this.bRepo = bRepo;
        this.cRepo = cRepo;
        this.mRepo = mRepo;
        this.rRepo = rRepo;
    }

    @Override
    public BookingResponse saveBooking(CreateBookingDto dto) {
        // Plocka ur objekt
        var customer = cRepo.findById(dto.customerId()).orElseThrow(() -> new NoCustomerFoundException("Ingen matchande kund hittades."));
        var room = rRepo.findById(dto.roomId()).orElseThrow(() -> new NoRoomFoundException("Inget matchande rum hittades."));
        var movie = mRepo.findById(dto.movieId()).orElseThrow(() -> new NoMovieFoundException("Ingen matchande film hittades.")); // Men Film är inte obligatoriskt? Lägg in funktion för att valiera bort och lägg en NOFILM i fältet?
        //skapa booking entitet
        Booking booking = BookingMapper.toEntity(dto);
        customer.addBooking(booking);
        room.addBooking(booking);
        movie.addBooking(booking);

        booking.setTotalPriceSEK(1);
        booking.setTotalPriceUSD(2);

        bRepo.save(booking);
        log.info("Bookning skapad med ID: {} ", booking.getId());
        return BookingMapper.toDto(booking);
    }

    @Override
    public BookingResponse patchBooking(Long id, PatchBookingDto dto) {
        var booking = bRepo.findById(id).orElseThrow(() -> new NoBookingFoundException("Ingen matchande bokning hittad."));
        if (dto.date() != null) booking.setDate(dto.date());
        if (dto.time() != null) booking.setTime(dto.time());
        if (dto.date() == null && dto.time() == null) {
            log.error("Ingen uppdatering gjord på bokning {}", booking.getId());
            throw new NoValidInputException("Ingen förändring gjord.");
        }
        bRepo.save(booking);
        log.debug("Bookning med ID: {} uppdaterad.", booking.getId());
        return BookingMapper.toDto(booking);
    }

    @Override
    public List<BookingResponse> findBookingsByCustomerId(Long id) {
        var c = cRepo.findById(id).orElseThrow(() -> new NoCustomerFoundException("Ingen matchande kund hittades."));
        return c.getBookingList().stream()
                .map(BookingMapper::toDto)
                .toList();
    }

    @Override
    public List<BookingResponse> findALlBookings() {
        return bRepo.findAll().stream()
                .map(BookingMapper::toDto)
                .toList();
    }
}


