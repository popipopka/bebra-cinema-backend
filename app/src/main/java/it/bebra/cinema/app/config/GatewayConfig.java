package it.bebra.cinema.app.config;

import it.bebra.cinema.database.repository.JpaTicketRepository;
import it.bebra.cinema.gateway.mapper.TicketMapper;
import it.bebra.cinema.gateway.repository.TicketRepositoryImpl;
import it.bebra.cinema.usecase.port.out.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный файл для настройки бинов Spring приложения.
 * <p>
 * Используется для настройки бинов шлюзов используемых в модуле {@link it.bebra.cinema.gateway}.
 */
@Configuration
@RequiredArgsConstructor
public class GatewayConfig {
    private final JpaTicketRepository jpaTicketRepository;
    private final TicketMapper ticketMapper;

    @Bean
    public TicketRepository ticketRepository() {
        return new TicketRepositoryImpl(jpaTicketRepository, ticketMapper);
    }
}
