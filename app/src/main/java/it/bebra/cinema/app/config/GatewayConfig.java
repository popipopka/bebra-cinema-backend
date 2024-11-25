package it.bebra.cinema.app.config;

import it.bebra.cinema.database.repository.JpaTicketRepository;
import it.bebra.cinema.gateway.mapper.GatewayTicketMapper;
import it.bebra.cinema.gateway.repository.TicketRepositoryImpl;
import it.bebra.cinema.usecase.port.out.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {
    private final JpaTicketRepository jpaTicketRepository;
    private final GatewayTicketMapper ticketMapper;

    @Bean
    public TicketRepository ticketRepository() {
        return new TicketRepositoryImpl(jpaTicketRepository, ticketMapper);
    }
}
