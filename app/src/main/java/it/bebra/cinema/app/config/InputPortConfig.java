package it.bebra.cinema.app.config;

import it.bebra.cinema.application.mapper.DomainMovieMapper;
import it.bebra.cinema.application.mapper.DomainSessionMapper;
import it.bebra.cinema.application.mapper.DomainTicketMapper;
import it.bebra.cinema.application.mapper.DomainUserMapper;
import it.bebra.cinema.application.port.in.usecase.*;
import it.bebra.cinema.application.port.out.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@RequiredArgsConstructor
@EnableJpaRepositories
public class InputPortConfig {
    private final AuthorityOutputPort authorityOutputPort;
    private final MovieOutputPort movieOutputPort;
    private final PasswordEncoderOutputPort passwordEncoderOutputPort;
    private final TicketOutputPort ticketOutputPort;
    private final UserOutputPort userOutputPort;

    private final DomainMovieMapper domainMovieMapper;
    private final DomainTicketMapper domainTicketMapper;
    private final DomainUserMapper domainUserMapper;


    @Bean
    public CreateUserUseCase createUserUseCase() {
        return new CreateUserUseCase(userOutputPort, authorityOutputPort, passwordEncoderOutputPort, domainUserMapper);
    }

    @Bean
    public GetAllMoviesUseCase getAllMoviesUseCase() {
        return new GetAllMoviesUseCase(movieOutputPort, domainMovieMapper);
    }

    @Bean
    public GetAllTicketsUseCase getAllTicketsUseCase() {
        return new GetAllTicketsUseCase(ticketOutputPort, domainTicketMapper);
    }

    @Bean
    public GetMovieUseCase getMovieUseCase() {
        return new GetMovieUseCase(movieOutputPort, domainMovieMapper);
    }
}
