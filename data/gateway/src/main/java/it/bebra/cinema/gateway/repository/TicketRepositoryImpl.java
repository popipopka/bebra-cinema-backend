package it.bebra.cinema.gateway.repository;

import it.bebra.cinema.database.repository.JpaTicketRepository;
import it.bebra.cinema.domain.Ticket;
import it.bebra.cinema.gateway.mapper.GatewayTicketMapper;
import it.bebra.cinema.usecase.port.out.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {
    private final JpaTicketRepository jpaTicketRepository;
    private final GatewayTicketMapper ticketMapper;

    @Override
    public List<Ticket> findAllByUserUsername(String username) {
        return jpaTicketRepository.findAllByUserUsername(username)
                .stream()
                .map(ticketMapper::toDomain)
                .toList();
    }
}
