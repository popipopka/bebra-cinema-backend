package it.bebra.cinema.application.port.out;

import it.bebra.cinema.domain.User;

import java.util.Optional;

public interface UserOutputPort {
    int create(User user);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    void update(User user);
}
