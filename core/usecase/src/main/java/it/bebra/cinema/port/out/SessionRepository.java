package it.bebra.cinema.port.out;

import it.bebra.cinema.model.Session;

import java.util.List;
import java.util.Optional;

public interface SessionRepository {
    Session save(Session session);

    Optional<Session> findById(int id);

    List<Session> findAll();

    void deleteById(int id);
}
