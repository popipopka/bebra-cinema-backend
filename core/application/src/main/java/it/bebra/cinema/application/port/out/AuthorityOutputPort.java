package it.bebra.cinema.application.port.out;

import it.bebra.cinema.domain.Authority;

import java.util.Optional;

public interface AuthorityOutputPort {
    Optional<Authority> findAuthorityByName(String name);
}
