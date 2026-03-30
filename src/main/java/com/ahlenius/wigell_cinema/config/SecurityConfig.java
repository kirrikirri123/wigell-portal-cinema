package com.ahlenius.wigell_cinema.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .cors(cors->{})
                .sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                );
              /*  .oauth2ResourceServer(oauth -> oauth.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter())))
                .exceptionHandling(e-> e.authenticationEntryPoint( new BearerTokenAuthenticationEntryPoint())
                );*/
        return http.build();

    }
    /*@Bean
    public Converter<Jwt,? extends AbstractAuthenticationToken> jwtAuthConverter() {
        return jwt -> {
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            Map<String,Object> realmAccess = jwt.getClaimAsMap("realm_access");
            if(realmAccess != null && realmAccess.get("roles") instanceof Collection<?> rawRoles) {
                for(Object r :rawRoles){
                    String role = String.valueOf(r).toUpperCase();
                    authorities.add(new SimpleGrantedAuthority("ROLE_"+ role));
                }
            }
            return new JwtAuthenticationToken(jwt,authorities);
        };
    }*/

}
