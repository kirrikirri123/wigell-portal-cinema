package com.ahlenius.wigell_cinema.config;

import com.ahlenius.wigell_cinema.model.AgeLimit;
import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.model.Genre;
import com.ahlenius.wigell_cinema.model.Movie;
import com.ahlenius.wigell_cinema.repository.CustomerRepository;
import com.ahlenius.wigell_cinema.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class DataLoader {
// 5 kunder, 5 filmer, två bokningar och 3 lokaler

    @Bean
    public CommandLineRunner initDatabase(CustomerRepository custRepo, MovieRepository movieRepo) {
        return args -> {

            List<Customer> testCustomers = List.of(
            new Customer("Kalle", "Karlsson", "k_karlsson@mail.com", "0701111111", "kalleskundnamn"),
            new Customer("Olle", "Olsson", "o_lsson@mail.com", "070222222", "olleskundnamn"),
            new Customer("Pelle", "Persson", "p_persson@mail.com", "0703333333", "pelleskundnamn"));

            custRepo.saveAll(testCustomers);

            List<Movie> testMovies = List.of(
            new Movie("Sagan", Genre.CARTOONS,85, AgeLimit.MINI),
            new Movie("Äventyret", Genre.ADVENTURE,120, AgeLimit.KIDS),
            new Movie("Gripande Verklighet", Genre.DOCUMENTARY,120, AgeLimit.TEENS),
            new Movie("Help", Genre.HORROR,190, AgeLimit.GROWNUP),
            new Movie("Chockerande vändingar", Genre.DRAMA,60, AgeLimit.TEENS)
                );
            movieRepo.saveAll(testMovies);

        };

    }


}
