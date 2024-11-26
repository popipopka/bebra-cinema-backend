package it.bebra.cinema.app.config;

import it.bebra.cinema.gateway.mapper.TicketMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный файл для настройки бинов Spring приложения.
 * <p>
 * Используется для настройки бинов мапперов используемых в модуле {@link it.bebra.cinema.gateway}.
 */
@Configuration
public class GatewayMapperConfig {

    @Bean
    public TicketMapper gatewayTicketMapper() {
        return TicketMapper.INSTANCE;
    }
}
