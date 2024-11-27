package it.bebra.cinema.app.config;

import it.bebra.cinema.usecase.mapper.DomainTicketMapper;
import it.bebra.cinema.usecase.mapper.DomainUserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный файл для настройки бинов Spring приложения.
 * <p>
 * Используется для настройки бинов мапперов используемых в модуле {@link it.bebra.cinema.usecase}.
 */
@Configuration
public class DomainMapperConfig {
    @Bean
    public DomainTicketMapper usecaseTicketMapper() {
        return DomainTicketMapper.INSTANCE;
    }

    @Bean
    public DomainUserMapper usecaseUserMapper() {
        return DomainUserMapper.INSTANCE;
    }
}
