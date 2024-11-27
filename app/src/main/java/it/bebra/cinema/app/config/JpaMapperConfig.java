package it.bebra.cinema.app.config;

import it.bebra.cinema.gateway.mapper.JpaAuthorityMapper;
import it.bebra.cinema.gateway.mapper.JpaTicketMapper;
import it.bebra.cinema.gateway.mapper.JpaUserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный файл для настройки бинов Spring приложения.
 * <p>
 * Используется для настройки бинов мапперов используемых в модуле {@link it.bebra.cinema.gateway}.
 */
@Configuration
public class JpaMapperConfig {

    @Bean
    public JpaTicketMapper gatewayTicketMapper() {
        return JpaTicketMapper.INSTANCE;
    }

    @Bean
    public JpaUserMapper gatewayUserMapper() {
        return JpaUserMapper.INSTANCE;
    }

    @Bean
    public JpaAuthorityMapper gatewayAuthorityMapper() {
        return JpaAuthorityMapper.INSTANCE;
    }
}
