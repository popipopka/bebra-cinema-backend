package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.persistence.database.spring.jpa.repository.JpaRefreshTokenRepository;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaRefreshTokenMapper;
import it.bebra.cinema.security.jwt.domain.Token;
import it.bebra.cinema.security.jwt.port.out.RefreshTokenOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaRefreshTokenRepositoryAdapter implements RefreshTokenOutputPort {
    private final JpaRefreshTokenRepository jpaRefreshTokenRepository;
    private final JpaRefreshTokenMapper tokenMapper;

    @Override
    public Optional<Token> findTokenByUserUsername(String username) {
        return jpaRefreshTokenRepository.findByUserUsername(username)
                .map(tokenMapper::toDomain);
    }

    @Override
    public void save(Token token) {
        jpaRefreshTokenRepository.save(tokenMapper.toEntity(token));
    }
}
