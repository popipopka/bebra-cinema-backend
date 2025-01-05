package it.bebra.cinema.app.config;

import it.bebra.cinema.application.mapper.DomainMovieMapper;
import it.bebra.cinema.application.mapper.DomainSessionMapper;
import it.bebra.cinema.application.mapper.DomainTicketMapper;
import it.bebra.cinema.application.mapper.DomainUserMapper;
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
}
