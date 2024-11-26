package it.bebra.cinema.usecase.port.out;

import it.bebra.cinema.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);

    void save(User user);
}
