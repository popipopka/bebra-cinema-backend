package it.bebra.cinema.application.port.out;

import it.bebra.cinema.domain.Ticket;

import java.util.List;

public interface TicketOutputPort {
    List<Ticket> findAllTicketsByUserUsername(String username);
}
