package it.bebra.cinema.app.config;

import it.bebra.cinema.application.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public DomainTicketMapper domainTicketMapper() {
        return DomainTicketMapper.INSTANCE;
    }

    @Bean
    public DomainUserMapper domainUserMapper() {
        return DomainUserMapper.INSTANCE;
    }

    @Bean
    public DomainMovieMapper domainMovieMapper() {
        return DomainMovieMapper.INSTANCE;
    }

    @Bean
    public DomainSessionMapper domainSessionMapper() {
        return DomainSessionMapper.INSTANCE;
    }

    @Bean
    public DomainHallMapper domainHallMapper() {
        return DomainHallMapper.INSTANCE;
    }
}
