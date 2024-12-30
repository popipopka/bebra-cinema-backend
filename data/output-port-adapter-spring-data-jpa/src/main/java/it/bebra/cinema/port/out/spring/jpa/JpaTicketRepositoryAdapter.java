package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.persistence.database.spring.jpa.repository.JpaTicketRepository;
import it.bebra.cinema.domain.Ticket;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaTicketMapper;
import it.bebra.cinema.application.port.out.TicketOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaTicketRepositoryAdapter implements TicketOutputPort {
    private final JpaTicketRepository jpaTicketRepository;
    private final JpaTicketMapper ticketMapper;

    @Override
    public List<Ticket> findAllTicketsByUserUsername(String username) {
        return jpaTicketRepository.findAllByUserUsername(username)
                .stream()
                .map(ticketMapper::toDomain)
                .toList();
    }
}
