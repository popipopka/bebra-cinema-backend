package it.bebra.cinema.gateway.repository;

import it.bebra.cinema.database.repository.JpaAuthorityRepository;
import it.bebra.cinema.domain.Authority;
import it.bebra.cinema.gateway.mapper.JpaAuthorityMapper;
import it.bebra.cinema.usecase.port.out.AuthorityRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AuthorityRepositoryImpl implements AuthorityRepository {
    private final JpaAuthorityRepository jpaAuthorityRepository;
    private final JpaAuthorityMapper authorityMapper;

    @Override
    public Optional<Authority> findByName(String name) {
        return jpaAuthorityRepository.findByName(name)
                .map(authorityMapper::toDomain);
    }
}
