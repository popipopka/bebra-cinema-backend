package it.bebra.gateway.repository;

import it.bebra.usecase.port.out.SessionRepository;
import it.bebra.database.repository.JpaSessionRepository;
import it.bebra.gateway.mapper.SessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {
    private final JpaSessionRepository jpaSessionRepository;
    private final SessionMapper sessionMapper;


}
