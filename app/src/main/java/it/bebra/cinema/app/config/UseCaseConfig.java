package it.bebra.cinema.app.config;

import it.bebra.cinema.usecase.mapper.TicketMapper;
import it.bebra.cinema.usecase.mapper.UserMapper;
import it.bebra.cinema.usecase.port.in.CreateUserUseCase;
import it.bebra.cinema.usecase.port.in.GetAllTicketsUseCase;
import it.bebra.cinema.usecase.port.out.AuthorityRepository;
import it.bebra.cinema.usecase.port.out.TicketRepository;
import it.bebra.cinema.usecase.port.out.UserRepository;
import it.bebra.cinema.usecase.usecase.CreateUserUseCaseImpl;
import it.bebra.cinema.usecase.usecase.GetAllTicketsUseCaseImpl;
import it.bebra.cinema.usecase.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный файл для настройки бинов Spring приложения.
 * <p>
 * Используется для настройки бинов сценариев использования используемых в модуле {@link it.bebra.cinema.usecase}.
 */
@Configuration
@RequiredArgsConstructor
public class UseCaseConfig {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    private final TicketMapper ticketMapper;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public GetAllTicketsUseCase getAllTicketsUseCase() {
        return new GetAllTicketsUseCaseImpl(ticketRepository, ticketMapper);
    }

    @Bean
    public CreateUserUseCase createUserUseCase() {
        return new CreateUserUseCaseImpl(userRepository, authorityRepository, passwordEncoder, userMapper);
    }
}
