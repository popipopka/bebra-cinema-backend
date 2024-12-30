package it.bebra.cinema.security.jwt.service.impl;

import io.jsonwebtoken.Jwts;
import it.bebra.cinema.domain.Authority;
import it.bebra.cinema.domain.User;
import it.bebra.cinema.security.jwt.domain.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component("accessJwtTokenService")
public class AccessJwtTokenService extends AbstractJwtTokenService {
    private static final long EXPIRATION_IN_MINUTES = 5;

    public AccessJwtTokenService(@Value("${jwt.secret.access}") String accessSecret) {
        super(accessSecret);
    }

    @Override
    public Token generateToken(User user) {
        return Token.builder()
                .user(user)
                .value(Jwts
                        .builder()
                        .signWith(secretKey)
                        .subject(user.getUsername())
                        .claim("authorities",
                                user.getAuthorities()
                                        .stream()
                                        .map(Authority::getName)
                                        .toList())
                        .issuedAt(Date.from(Instant.now()))
                        .expiration(Date.from(Instant.now().plus(EXPIRATION_IN_MINUTES, ChronoUnit.MINUTES)))
                        .compact())
                .build();
    }
}
