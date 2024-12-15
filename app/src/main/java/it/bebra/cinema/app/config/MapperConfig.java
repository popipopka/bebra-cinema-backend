package it.bebra.cinema.app.config;

import it.bebra.cinema.application.mapper.DomainMovieMapper;
import it.bebra.cinema.application.mapper.DomainTicketMapper;
import it.bebra.cinema.application.mapper.DomainUserMapper;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaAuthorityMapper;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaMovieMapper;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaTicketMapper;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaUserMapper;
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
    public JpaTicketMapper jpaTicketMapper() {
        return JpaTicketMapper.INSTANCE;
    }

    @Bean
    public JpaUserMapper jpaUserMapper() {
        return JpaUserMapper.INSTANCE;
    }

    @Bean
    public JpaAuthorityMapper jpaAuthorityMapper() {
        return JpaAuthorityMapper.INSTANCE;
    }

    @Bean
    public JpaMovieMapper jpaMovieMapper() {
        return JpaMovieMapper.INSTANCE;
    }
}
