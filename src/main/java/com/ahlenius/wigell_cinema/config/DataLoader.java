package com.ahlenius.wigell_cinema.config;

import com.ahlenius.wigell_cinema.model.Customer;
import com.ahlenius.wigell_cinema.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class DataLoader {
//String firstName, String lastName,String email,String phone, String username

    @Bean
    public CommandLineRunner initDatabase(CustomerRepository repo) {
        return args -> {

            List<Customer> testCustomers = List.of(
                new Customer("Kalle","Karlsson","k_karlsson@mail.com","0701111111","kalleskundnamn"),
                new Customer("Olle","Olsson","o_lsson@mail.com","070222222","olleskundnamn"),
                new Customer("Pelle","Persson","p_persson@mail.com","0703333333","pelleskundnamn"));

                repo.saveAll(testCustomers);


        };

    }


}
