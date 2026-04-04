package com.ahlenius.wigell_cinema.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientConfig {

    @Value("${converter.service.url}")
    private String converterURL;


    @Bean
    WebCl

}
