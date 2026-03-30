package com.ahlenius.wigell_cinema.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {


    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {
        };

    }


}
