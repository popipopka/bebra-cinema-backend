package it.bebra.cinema.usecase.port.out;

import it.bebra.cinema.domain.Ticket;

import java.util.List;

public interface TicketRepository {
    List<Ticket> findAllByUserUsername(String username);
}
