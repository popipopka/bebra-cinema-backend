package it.bebra.cinema.security.jwt.service.impl;

import io.jsonwebtoken.Jwts;
import it.bebra.cinema.domain.User;
import it.bebra.cinema.security.jwt.domain.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component("refreshJwtTokenService")
public class RefreshJwtTokenService extends AbstractJwtTokenService {
    private static final long EXPIRATION_IN_DAYS = 30;

    public RefreshJwtTokenService(@Value("${jwt.secret.refresh}") String refreshSecret) {
        super(refreshSecret);
    }

    @Override
    public Token generateToken(User user) {
        return Token.builder()
                .user(user)
                .value(Jwts
                        .builder()
                        .signWith(secretKey)
                        .subject(user.getUsername())
                        .issuedAt(Date.from(Instant.now()))
                        .expiration(Date.from(Instant.now().plus(EXPIRATION_IN_DAYS, ChronoUnit.DAYS)))
                        .compact())
                .build();
    }
}
