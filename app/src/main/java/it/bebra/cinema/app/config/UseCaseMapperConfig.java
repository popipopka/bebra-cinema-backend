package it.bebra.cinema.app.config;

import it.bebra.cinema.usecase.mapper.TicketMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseMapperConfig {
    @Bean
    public TicketMapper ticketMapper() {
        return TicketMapper.INSTANCE;
    }
}
