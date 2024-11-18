package port.out;

import it.bebra.domain.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    Ticket save(Ticket ticket);

    Optional<Ticket> findById(int id);

    List<Ticket> findAll();

    void deleteById(int id);
}
