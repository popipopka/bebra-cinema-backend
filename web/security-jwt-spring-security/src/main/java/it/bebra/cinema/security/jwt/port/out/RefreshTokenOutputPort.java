package it.bebra.cinema.security.jwt.port.out;

import it.bebra.cinema.security.jwt.domain.Token;

import java.util.Optional;

public interface RefreshTokenOutputPort {
    Optional<Token> findTokenByUserUsername(String username);

    void save(Token token);
}
