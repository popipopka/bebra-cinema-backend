package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.application.port.out.SessionOutputPort;
import it.bebra.cinema.domain.Session;
import it.bebra.cinema.persistence.database.spring.jpa.repository.JpaSessionRepository;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaSessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaSessionRepositoryAdapter implements SessionOutputPort {
    private final JpaSessionRepository jpaSessionRepository;
    private final JpaSessionMapper jpaSessionMapper;

    @Override
    public List<Session> findAllUpcomingWithEmptySeatsByMovieId(int movieId) {
        return jpaSessionRepository.findAllUpcomingWithEmptySeatsByMovieId(movieId)
                .stream()
                .map(jpaSessionMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Session> findById(int id) {
        return jpaSessionRepository.findById(id)
                .map(jpaSessionMapper::toDomain);
    }
}
