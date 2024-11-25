package it.bebra.gateway.repository;

import it.bebra.domain.model.Ticket;
import it.bebra.usecase.port.out.TicketRepository;
import it.bebra.database.repository.JpaTicketRepository;
import it.bebra.gateway.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {
    private final JpaTicketRepository jpaTicketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public List<Ticket> findAllByUserUsername(String username) {
        return jpaTicketRepository.findAllByUserUsername(username)
                .stream()
                .map(ticketMapper::toDomain)
                .toList();
    }
}
