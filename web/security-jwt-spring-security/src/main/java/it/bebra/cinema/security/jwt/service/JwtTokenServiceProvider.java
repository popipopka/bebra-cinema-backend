package it.bebra.cinema.security.jwt.service;

import it.bebra.cinema.domain.User;
import it.bebra.cinema.security.jwt.domain.Token;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class JwtTokenServiceProvider {

    private final JwtTokenService accessJwtTokenService;
    private final JwtTokenService refreshJwtTokenService;

    public JwtTokenServiceProvider(JwtTokenService accessJwtTokenService,
                                   JwtTokenService refreshJwtTokenService) {
        this.accessJwtTokenService = accessJwtTokenService;
        this.refreshJwtTokenService = refreshJwtTokenService;
    }

    private <T> T resolveJwtTokenService(Function<JwtTokenService, T> serviceFunction, JwtTokenType tokenType) {
        return switch (tokenType) {
            case ACCESS -> serviceFunction.apply(accessJwtTokenService);
            case REFRESH -> serviceFunction.apply(refreshJwtTokenService);
        };
    }

    public Token generateToken(User user, JwtTokenType tokenType) {
        return resolveJwtTokenService(service -> service.generateToken(user), tokenType);
    }

    public boolean isValid(String token, JwtTokenType tokenType) {
        return resolveJwtTokenService(service -> service.isValid(token), tokenType);
    }

    public String extractUsername(String token, JwtTokenType tokenType) {
        return resolveJwtTokenService(service -> service.extractUsername(token), tokenType);
    }
}
