package it.bebra.cinema.repository;

import it.bebra.cinema.port.out.TicketRepository;
import it.bebra.cinema.repository.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {
    private final JpaTicketRepository jpaTicketRepository;
    private final TicketMapper ticketMapper;


}
