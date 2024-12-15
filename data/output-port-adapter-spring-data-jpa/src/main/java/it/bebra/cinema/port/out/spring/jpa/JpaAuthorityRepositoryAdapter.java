package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.database.spring.jpa.repository.JpaAuthorityRepository;
import it.bebra.cinema.domain.Authority;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaAuthorityMapper;
import it.bebra.cinema.application.port.out.AuthorityOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaAuthorityRepositoryAdapter implements AuthorityOutputPort {
    private final JpaAuthorityRepository jpaAuthorityRepository;
    private final JpaAuthorityMapper authorityMapper;

    @Override
    public Optional<Authority> findAuthorityByName(String name) {
        return jpaAuthorityRepository.findByName(name)
                .map(authorityMapper::toDomain);
    }
}
