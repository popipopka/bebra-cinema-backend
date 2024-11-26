package it.bebra.cinema.app.config;

import it.bebra.cinema.gateway.mapper.AuthorityMapper;
import it.bebra.cinema.gateway.mapper.TicketMapper;
import it.bebra.cinema.gateway.mapper.UserMapper;
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

    @Bean
    public UserMapper gatewayUserMapper() {
        return UserMapper.INSTANCE;
    }

    @Bean
    public AuthorityMapper gatewayAuthorityMapper() {
        return AuthorityMapper.INSTANCE;
    }
}
