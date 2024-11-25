package it.bebra.cinema.repository;

import it.bebra.cinema.port.out.SessionRepository;
import it.bebra.cinema.repository.mapper.SessionMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {
    private final JpaSessionRepository jpaSessionRepository;
    private final SessionMapper sessionMapper;


}
