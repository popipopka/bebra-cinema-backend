package it.bebra.cinema.app.config;

import it.bebra.cinema.application.mapper.DomainMovieMapper;
import it.bebra.cinema.application.mapper.DomainSessionMapper;
import it.bebra.cinema.application.mapper.DomainTicketMapper;
import it.bebra.cinema.application.mapper.DomainUserMapper;
import it.bebra.cinema.application.port.in.*;
import it.bebra.cinema.application.port.in.usecase.*;
import it.bebra.cinema.application.port.out.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class InputPortConfig {
    private final AuthorityOutputPort authorityOutputPort;
    private final MovieOutputPort movieOutputPort;
    private final PasswordEncoderOutputPort passwordEncoderOutputPort;
    private final TicketOutputPort ticketOutputPort;
    private final UserOutputPort userOutputPort;
    private final SessionOutputPort sessionOutputPort;

    private final DomainMovieMapper domainMovieMapper;
    private final DomainTicketMapper domainTicketMapper;
    private final DomainUserMapper domainUserMapper;
    private final DomainSessionMapper domainSessionMapper;


    @Bean
    public CreateUserInputPort createUserUseCase() {
        return new CreateUserUseCase(userOutputPort, authorityOutputPort, passwordEncoderOutputPort, domainUserMapper);
    }

    @Bean
    public GetAllMoviesInputPort getAllMoviesUseCase() {
        return new GetAllMoviesUseCase(movieOutputPort, domainMovieMapper);
    }

    @Bean
    public GetAllTicketsInputPort getAllTicketsUseCase() {
        return new GetAllTicketsUseCase(ticketOutputPort, domainTicketMapper);
    }

    @Bean
    public GetMovieInputPort getMovieUseCase() {
        return new GetMovieUseCase(movieOutputPort, domainMovieMapper);
    }

    @Bean
    public GetAllMovieSessionsInputPort getMovieSessionsInputPort() {
        return new GetAllMovieSessionsUseCase(sessionOutputPort, domainSessionMapper);
    }

    @Bean
    public GetUserInputPort getUserInputPort() {
        return new GetUserUseCase(userOutputPort, domainUserMapper);
    }

    @Bean
    public CreateTicketInputPort createTicketInputPort() {
        return new CreateTicketUseCase(ticketOutputPort, userOutputPort, sessionOutputPort);
    }

    @Bean
    public UpdateUserInputPort updateUserInputPort() {
        return new UpdateUserUseCase(userOutputPort, domainUserMapper);
    }

    @Bean
    public DeleteTicketInputPort deleteTicketInputPort() {
        return new DeleteTicketUseCase(ticketOutputPort);
    }

    @Bean
    public SoftDeleteUserInputPort deleteUserInputPort() {
        return new SoftDeleteUserUseCase(userOutputPort);
    }
}
