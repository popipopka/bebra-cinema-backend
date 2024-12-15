package it.bebra.cinema.app.config;

import it.bebra.cinema.database.spring.jpa.repository.JpaAuthorityRepository;
import it.bebra.cinema.database.spring.jpa.repository.JpaMovieRepository;
import it.bebra.cinema.database.spring.jpa.repository.JpaTicketRepository;
import it.bebra.cinema.database.spring.jpa.repository.JpaUserRepository;
import it.bebra.cinema.port.out.spring.jpa.JpaAuthorityRepositoryAdapter;
import it.bebra.cinema.port.out.spring.jpa.JpaMovieRepositoryAdapter;
import it.bebra.cinema.port.out.spring.jpa.JpaTicketRepositoryAdapter;
import it.bebra.cinema.port.out.spring.jpa.JpaUserRepositoryAdapter;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaAuthorityMapper;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaMovieMapper;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaTicketMapper;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OutputPortConfig {
    private final JpaAuthorityRepository jpaAuthorityRepository;
    private final JpaMovieRepository jpaMovieRepository;
    private final JpaTicketRepository jpaTicketRepository;
    private final JpaUserRepository jpaUserRepository;

    private final JpaAuthorityMapper jpaAuthorityMapper;
    private final JpaMovieMapper jpaMovieMapper;
    private final JpaTicketMapper jpaTicketMapper;
    private final JpaUserMapper jpaUserMapper;

    @Bean
    public JpaAuthorityRepositoryAdapter jpaAuthorityRepositoryAdapter() {
        return new JpaAuthorityRepositoryAdapter(jpaAuthorityRepository, jpaAuthorityMapper);
    }

    @Bean
    public JpaMovieRepositoryAdapter jpaMovieRepositoryAdapter() {
        return new JpaMovieRepositoryAdapter(jpaMovieRepository, jpaMovieMapper);
    }

    @Bean
    public JpaTicketRepositoryAdapter jpaTicketRepositoryAdapter() {
        return new JpaTicketRepositoryAdapter(jpaTicketRepository, jpaTicketMapper);
    }

    @Bean
    public JpaUserRepositoryAdapter jpaUserRepositoryAdapter() {
        return new JpaUserRepositoryAdapter(jpaUserRepository, jpaUserMapper);
    }
}
