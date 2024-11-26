package it.bebra.cinema.app.config;

import it.bebra.cinema.usecase.mapper.TicketMapper;
import it.bebra.cinema.usecase.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный файл для настройки бинов Spring приложения.
 * <p>
 * Используется для настройки бинов мапперов используемых в модуле {@link it.bebra.cinema.usecase}.
 */
@Configuration
public class UseCaseMapperConfig {
    @Bean
    public TicketMapper usecaseTicketMapper() {
        return TicketMapper.INSTANCE;
    }

    @Bean
    public UserMapper usecaseUserMapper() {
        return UserMapper.INSTANCE;
    }
}
