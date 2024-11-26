package it.bebra.cinema.usecase.port.out;

import it.bebra.cinema.domain.Authority;

import java.util.Optional;

public interface AuthorityRepository {
    Optional<Authority> findByName(String name);
}
