package com.ahlenius.wigell_cinema.config;
import com.ahlenius.wigell_cinema.model.*;
import com.ahlenius.wigell_cinema.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Configuration
public class DataLoader {
// 5 kunder, 5 filmer, två bokningar och 3 lokaler

    @Bean
    public CommandLineRunner initDatabase(CustomerRepository custRepo, MovieRepository movieRepo, RoomRepository roomRepo, BookingRepository bookingRepo, ScreeningRepository screenRepo, TicketRepository ticketRepo) {
        return args -> {
            Customer c1 = new Customer("Kalle", "Karlsson", "k_karlsson@mail.com", "0701111111", "kalleskundnamn");
            List<Customer> testCustomers = List.of(
                    new Customer("Olle", "Olsson", "o_lsson@mail.com", "070222222", "olleskundnamn"),
                    new Customer("Pelle", "Persson", "p_persson@mail.com", "0703333333", "pelleskundnamn"),
                    new Customer("Ash", "Olesson", "asshole@mail.com", "070222222", "asskundnamn"),
                    new Customer("Ad", "minsson", "admin@mail.com", "0703333333", "admin"));

            custRepo.save(c1);

                    Movie m1 = new Movie("Sagan", Genre.CARTOONS, 85, AgeLimit.MINI);
                List<Movie> testMovies = List.of(
                    new Movie("Äventyret", Genre.ADVENTURE, 120, AgeLimit.KIDS),
                    new Movie("Gripande Verklighet", Genre.DOCUMENTARY, 120, AgeLimit.TEENS),
                    new Movie("Help", Genre.HORROR, 190, AgeLimit.GROWNUP),
                    new Movie("Chockerande vändingar", Genre.DRAMA, 60, AgeLimit.TEENS)

            );
            movieRepo.save(m1);

                    Room r1 = new Room("Krokodilens mun", 35, "Ljud,Bild");
            List<Room> testRooms = List.of(
                    new Room("Elefantes rygg", 50, "Ljud, Bild,Hörslinga"),
                    new Room("Örnnästet", 10, "Ljud,Bild"),
                    new Room("Bäverns hydda", 75, "Ljud,Bild,Hörslinga"),
                    new Room("Spindelns nät", 25, "Ljud,Bild")
            );
            roomRepo.save(r1);


            List<Booking> testBookings = List.of(
                    new Booking(c1,10,r1,LocalDate.of(2026,4,13), LocalTime.of(18,30,0),m1,false)
                  /*  new Booking(),
                    new Booking(55,, 2026415, 19.00,, false),
                    new Booking(55,, 2026415, 19.00,, false),
                    new Booking(55,, 2026415, 19.00,, false)*/
                                );
            bookingRepo.saveAll(testBookings);


            Screening s1= new Screening(m1,r1, LocalDate.of(2026,5,18),LocalTime.of(14,30));
            List<Screening> testScreening = List.of(
                new Screening(m1,r1, LocalDate.of(2026,4,15),LocalTime.of(19,30)),
                new Screening(m1,r1, LocalDate.of(2026,4,15),LocalTime.of(15,0)),
                new Screening(m1,r1, LocalDate.of(2026,4,15),LocalTime.of(21,0)));
            screenRepo.save(s1);
            screenRepo.saveAll(testScreening);

            List<Ticket> testTickets = List.of(
                    new Ticket(s1,c1)
            );
            ticketRepo.saveAll(testTickets);

            //List<Address> testAddresses = List.of();

        };

    }

}
