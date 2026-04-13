package com.ahlenius.wigell_cinema.config;

import com.ahlenius.wigell_cinema.model.*;
import com.ahlenius.wigell_cinema.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Configuration
public class DataLoader {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    @Bean
    public CommandLineRunner initDatabase(CustomerRepository custRepo, MovieRepository movieRepo,
                                          RoomRepository roomRepo, BookingRepository bookingRepo,
                                          ScreeningRepository screenRepo, TicketRepository ticketRepo,
                                          AddressRepository addressRepo) {
        return args -> {

            Customer c1 = new Customer("Kalle", "Karlsson", "k_karlsson@mail.com", "0701111111", "kalleskundnamn");
            Customer c2 = new Customer("Olle", "Olsson", "o_lsson@mail.com", "070222222", "olleskundnamn");
            Customer c3 = new Customer("Pelle", "Persson", "p_persson@mail.com", "0703333333", "pelleskundnamn");
            Customer c4 = new Customer("Ash", "Olesson", "asshole@mail.com", "070222222", "asskundnamn");
            Customer c5 = new Customer("Ad", "minsson", "admin@mail.com", "0703333333", "admin");

            List<Customer> testCustomers = List.of(c1, c2, c3, c4, c5);
            custRepo.saveAll(testCustomers);
            log.info("{} test kunder laddade.Admin är {}",testCustomers.size(),c5.getFirstName()+" "+c5.getLastName());

            Movie m1 = new Movie("Sagan", Genre.CARTOONS, 85, AgeLimit.MINI);
            Movie m2 = new Movie("Äventyret", Genre.ADVENTURE, 120, AgeLimit.KIDS);
            Movie m3 = new Movie("Gripande Verklighet", Genre.DOCUMENTARY, 120, AgeLimit.TEENS);
            Movie m4 = new Movie("Help", Genre.HORROR, 190, AgeLimit.GROWNUP);
            Movie m5 = new Movie("Chockerande vändingar", Genre.DRAMA, 60, AgeLimit.TEENS);
            Movie noMovie = new Movie("NO MOVIE", Genre.SILENT, 60, AgeLimit.MINI);

            List<Movie> testMovies = List.of(m1, m2, m3, m4, m5,noMovie);
            movieRepo.saveAll(testMovies);
            log.info("{} st filmer laddade.", testMovies.size());

            Room r1 = new Room("Krokodilens mun", 35, "Ljud,Bild");
            Room r2 = new Room("Elefantens rygg", 50, "Ljud, Bild,Hörslinga");
            Room r3 = new Room("Örnnästet", 10, "Ljud,Bild");
            Room r4 = new Room("Bäverns hydda", 75, "Ljud,Bild,Hörslinga");
            Room r5 = new Room("Spindelns nät", 25, "Ljud,Bild");

            List<Room> testRooms = List.of(r1, r2, r3, r4, r5);
            roomRepo.saveAll(testRooms);
            log.info("{} st lokaler laddade.", testRooms.size());

            Booking b1 = new Booking(c1, 10, r1, LocalDate.of(2026, 4, 13), LocalTime.of(18, 30, 0), m1, false);
            b1.setTotalPriceSEK(BigDecimal.valueOf(1700)); b1.setTotalPriceUSD(BigDecimal.valueOf(1700).multiply(BigDecimal.valueOf(0.11)));
            Booking b2 = new Booking(c2, 65, r4, LocalDate.of(2026, 5, 15), LocalTime.of(12, 0, 0), m2, false);
            b2.setTotalPriceSEK(BigDecimal.valueOf(850)); b2.setTotalPriceUSD(BigDecimal.valueOf(850).multiply(BigDecimal.valueOf(0.11)));
            Booking b3 = new Booking(c3, 25, r5, LocalDate.of(2026, 6, 6), LocalTime.of(15, 0, 0),noMovie, true);
            b3.setTotalPriceSEK(BigDecimal.valueOf(1100)); b3.setTotalPriceUSD(BigDecimal.valueOf(1100).multiply(BigDecimal.valueOf(0.11)));
            Booking b4 = new Booking(c4, 5, r3, LocalDate.of(2026, 7, 1), LocalTime.of(19, 30, 0), m4, false);
            b4.setTotalPriceSEK(BigDecimal.valueOf(1000)); b4.setTotalPriceUSD(BigDecimal.valueOf(1000).multiply(BigDecimal.valueOf(0.11)));
            Booking b5 = new Booking(c5, 47, r2, LocalDate.of(2026, 8, 25), LocalTime.of(20, 10, 0), m5, false);
            b5.setTotalPriceSEK(BigDecimal.valueOf(2000)); b5.setTotalPriceUSD(BigDecimal.valueOf(2000).multiply(BigDecimal.valueOf(0.11)));

            List<Booking> testBookings = List.of(b1, b2, b3, b4, b5);
            bookingRepo.saveAll(testBookings);
            log.info("{} st bokningar laddade.", testBookings.size());

            Screening s1 = new Screening(m1, r1, LocalDate.of(2026, 5, 18), LocalTime.of(14, 30));
            Screening s2 = new Screening(m2, r2, LocalDate.of(2026, 4, 15), LocalTime.of(19, 30));
            Screening s3 = new Screening(m3, r1, LocalDate.of(2026, 4, 15), LocalTime.of(15, 0));
            Screening s4 = new Screening(m4, r3, LocalDate.of(2026, 4, 15), LocalTime.of(21, 0));
            Screening s5 = new Screening(m5, r5, LocalDate.of(2026, 4, 15), LocalTime.of(21, 0));

            List<Screening> testScreening = List.of(s1, s2, s3, s4, s5);
            screenRepo.saveAll(testScreening);
            log.info("{} st visningar laddade.", testScreening.size());

            List<Ticket> testTickets = List.of(
                    new Ticket(s1, c1),
                    new Ticket(s1, c2),
                    new Ticket(s2, c1),
                    new Ticket(s4, c3),
                    new Ticket(s3, c1),
                    new Ticket(s5, c4),
                    new Ticket(s5, c5));

            testTickets.forEach(ticket -> {ticket.setTotalPriceSEK(BigDecimal.valueOf(95));});
            ticketRepo.saveAll(testTickets);
            log.info("{} st biljetter laddade.", testTickets.size());

            List<Address> testAddresses = List.of(
                    new Address("Brogatan 12", "90324", "Umeå", c2),
                    new Address("Odalgatan 6", "98134", "Skellefteå", c3));
            addressRepo.saveAll(testAddresses);// behöver dessa adderas i kundens lista?
            log.info("{} st addresser laddade.", testAddresses.size());

        };

    }

}
