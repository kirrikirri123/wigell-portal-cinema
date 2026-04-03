package com.ahlenius.wigell_cinema.config;
import com.ahlenius.wigell_cinema.model.*;
import com.ahlenius.wigell_cinema.repository.CustomerRepository;
import com.ahlenius.wigell_cinema.repository.MovieRepository;
import com.ahlenius.wigell_cinema.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Configuration
public class DataLoader {
// 5 kunder, 5 filmer, två bokningar och 3 lokaler

    @Bean
    public CommandLineRunner initDatabase(CustomerRepository custRepo, MovieRepository movieRepo, RoomRepository roomRepo) {
        return args -> {

            List<Customer> testCustomers = List.of(
                    new Customer("Kalle", "Karlsson", "k_karlsson@mail.com", "0701111111", "kalleskundnamn"),
                    new Customer("Olle", "Olsson", "o_lsson@mail.com", "070222222", "olleskundnamn"),
                    new Customer("Pelle", "Persson", "p_persson@mail.com", "0703333333", "pelleskundnamn"),
                    new Customer("Ash", "Olesson", "asshole@mail.com", "070222222", "asskundnamn"),
                    new Customer("Ad", "minsson", "admin@mail.com", "0703333333", "admin"));

            custRepo.saveAll(testCustomers);

            List<Movie> testMovies = List.of(
                    new Movie("Sagan", Genre.CARTOONS, 85, AgeLimit.MINI),
                    new Movie("Äventyret", Genre.ADVENTURE, 120, AgeLimit.KIDS),
                    new Movie("Gripande Verklighet", Genre.DOCUMENTARY, 120, AgeLimit.TEENS),
                    new Movie("Help", Genre.HORROR, 190, AgeLimit.GROWNUP),
                    new Movie("Chockerande vändingar", Genre.DRAMA, 60, AgeLimit.TEENS),

            );
            movieRepo.saveAll(testMovies);

            List<Room> testRooms = List.of(
                    new Room("Krokodilens mun", 35, "Ljud,Bild"),
                    new Room("Elefantes rygg", 50, "Ljud, Bild,Hörslinga"),
                    new Room("Örnnästet", 10, "Ljud,Bild"),
                    new Room("Bäverns hydda", 75, "Ljud,Bild,Hörslinga"),
                    new Room("Spindelns nät", 25, "Ljud,Bild")
            );
            roomRepo.saveAll(testRooms);


            List<Booking> testBookings = List.of(
                    new Booking(55,, 2026415, 19.00,, false)
            );
            //List<Ticket> testTickets = List.of();
            //List<Address> testAddresses = List.of();

        };

    }


}
