package it.bebra.gateway.repository;

import it.bebra.database.entity.JpaSession;
import it.bebra.domain.model.Session;
import it.bebra.database.repository.JpaSessionRepository;
import it.bebra.gateway.repository.mapper.SessionMapper;
import lombok.RequiredArgsConstructor;
import port.out.SessionRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {
    private final JpaSessionRepository jpaSessionRepository;
    private final SessionMapper sessionMapper;

    @Override
    public Session save(Session session) {
        JpaSession jpaSession = sessionMapper.toEntity(session);

        jpaSession = jpaSessionRepository.save(jpaSession);

        return sessionMapper.toDomain(jpaSession);
    }

    @Override
    public Optional<Session> findById(int id) {
        return jpaSessionRepository.findById(id).map(sessionMapper::toDomain);
    }

    @Override
    public List<Session> findAll() {
        return jpaSessionRepository.findAll().stream()
                .map(sessionMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        jpaSessionRepository.deleteById(id);
    }
}
