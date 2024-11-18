package it.bebra.cinema.repository;

import it.bebra.cinema.entity.JpaTicket;
import it.bebra.cinema.model.Ticket;
import it.bebra.cinema.repository.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import it.bebra.cinema.port.out.TicketRepository;

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
