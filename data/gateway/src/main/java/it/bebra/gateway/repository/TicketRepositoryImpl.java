package it.bebra.gateway.repository;

import it.bebra.database.entity.JpaTicket;
import it.bebra.domain.model.Ticket;
import it.bebra.database.repository.JpaTicketRepository;
import it.bebra.gateway.repository.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import port.out.TicketRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {
    private final JpaTicketRepository jpaTicketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public Ticket save(Ticket ticket) {
        JpaTicket jpaTicket = ticketMapper.toEntity(ticket);

        jpaTicket = jpaTicketRepository.save(jpaTicket);

        return ticketMapper.toDomain(jpaTicket);
    }

    @Override
    public Optional<Ticket> findById(int id) {
        return jpaTicketRepository.findById(id)
                .map(ticketMapper::toDomain);
    }

    @Override
    public List<Ticket> findAll() {
        return jpaTicketRepository.findAll().stream()
                .map(ticketMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        jpaTicketRepository.deleteById(id);
    }
}
