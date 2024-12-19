package it.bebra.cinema.application.port.out;

import it.bebra.cinema.domain.User;

import java.util.Optional;

public interface UserOutputPort {
    void createUser(User user);

    Optional<User> findUserByUsername(String username);

    boolean existsUserByUsername(String username);
}
