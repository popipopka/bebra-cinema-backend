package it.bebra.usecase.port.out;

import it.bebra.domain.model.Ticket;

import java.util.List;

public interface TicketRepository {
    List<Ticket> findAllByUserUsername(String username);
}
