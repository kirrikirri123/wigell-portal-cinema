package com.ahlenius.wigell_cinema.service;

import com.ahlenius.wigell_cinema.dto.bookingDto.BookingResponse;
import com.ahlenius.wigell_cinema.dto.bookingDto.PatchBookingDto;
import com.ahlenius.wigell_cinema.dto.bookingDto.CreateBookingDto;
import com.ahlenius.wigell_cinema.exception.NoMovieFoundException;
import com.ahlenius.wigell_cinema.exception.NoRoomFoundException;
import com.ahlenius.wigell_cinema.exception.NoCustomerFoundException;
import com.ahlenius.wigell_cinema.mapper.BookingMapper;
import com.ahlenius.wigell_cinema.model.Booking;
import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.model.Movie;
import com.ahlenius.wigell_cinema.model.Room;
import com.ahlenius.wigell_cinema.repository.BookingRepository;
import com.ahlenius.wigell_cinema.repository.CustomerRepository;
import com.ahlenius.wigell_cinema.repository.MovieRepository;
import com.ahlenius.wigell_cinema.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

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
        Customer customer = cRepo.findById(dto.customerId()).orElseThrow(() -> new NoCustomerFoundException("Ingen matchande kund hittades."));
        Room room = rRepo.findById(dto.roomId()).orElseThrow(() -> new NoRoomFoundException("Inget matchande rum hittades."));
        Movie movie = mRepo.findById(dto.movieId()).orElseThrow(() -> new NoMovieFoundException("Ingen matchande film hittades."));
        //skapa booking entitet
        Booking booking = BookingMapper.toEntity(dto);
        customer.addBooking(booking);
        room.addBooking(booking);
        movie.addBooking(booking);

        booking.setTotalPriceSEK(1);
        booking.setTotalPriceUSD(2);

        bRepo.save(booking);
              BookingResponse response = BookingMapper.toDto(booking);
        return response;
    }

    @Override
    public BookingResponse patchBooking(Long id, PatchBookingDto dto) {

        return null;
    }

    @Override
    public List<BookingResponse> findBookingsByCustomerId(Long id) { //detta är nog ingen bra lösning, när man ändå har param??
        Customer c = cRepo.findById(id).orElseThrow(() -> new NoCustomerFoundException("Ingen matchande kund hittades."));
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


