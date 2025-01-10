package it.bebra.cinema.application.port.out;

import it.bebra.cinema.domain.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketOutputPort {
    List<Ticket> findAllByUserUsername(String username, int lastId, int limit);

    boolean existsByUserUsernameAndIdLessThan(String username, int id);

    int countBySessionId(int sessionId);

    int create(Ticket ticket);

    Optional<Ticket> findById(int id);

    void delete(int id);
}
