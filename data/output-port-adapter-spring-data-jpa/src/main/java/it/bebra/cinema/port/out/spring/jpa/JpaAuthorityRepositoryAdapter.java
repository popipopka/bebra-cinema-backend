package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.persistence.database.spring.jpa.repository.JpaAuthorityRepository;
import it.bebra.cinema.domain.Authority;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaAuthorityMapper;
import it.bebra.cinema.application.port.out.AuthorityOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaAuthorityRepositoryAdapter implements AuthorityOutputPort {
    private final JpaAuthorityRepository jpaAuthorityRepository;
    private final JpaAuthorityMapper authorityMapper;

    @Override
    public Optional<Authority> findByName(String name) {
        return jpaAuthorityRepository.findByName(name)
                .map(authorityMapper::toDomain);
    }
}
