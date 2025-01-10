package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.persistence.database.spring.jpa.repository.JpaTicketRepository;
import it.bebra.cinema.domain.Ticket;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaTicketMapper;
import it.bebra.cinema.application.port.out.TicketOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaTicketRepositoryAdapter implements TicketOutputPort {
    private final JpaTicketRepository jpaTicketRepository;
    private final JpaTicketMapper ticketMapper;

    @Override
    public List<Ticket> findAllByUserUsername(String username, int id, int limit) {
        return jpaTicketRepository.findAllWithLimitByUserUsernameAndIdLessThan(username, id, limit)
                .stream()
                .map(ticketMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByUserUsernameAndIdLessThan(String username, int id) {
        return jpaTicketRepository.existsByUserUsernameAndIdLessThan(username, id);
    }

    @Override
    public int countBySessionId(int sessionId) {
        return jpaTicketRepository.countBySessionId(sessionId);
    }

    @Override
    public int create(Ticket ticket) {
        return jpaTicketRepository
                .save(ticketMapper.toEntity(ticket))
                .getId();
    }

    @Override
    public Optional<Ticket> findById(int id) {
        return jpaTicketRepository
                .findById(id)
                .map(ticketMapper::toDomain);
    }

    @Override
    public void delete(int id) {
        jpaTicketRepository.deleteById(id);
    }
}
