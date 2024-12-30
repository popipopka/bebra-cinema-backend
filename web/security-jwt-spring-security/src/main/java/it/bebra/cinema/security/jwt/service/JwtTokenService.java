package it.bebra.cinema.security.jwt.service;

import it.bebra.cinema.domain.User;
import it.bebra.cinema.security.jwt.domain.Token;

public interface JwtTokenService {
    Token generateToken(User user);

    boolean isValid(String token);

    String extractUsername(String token);
}
