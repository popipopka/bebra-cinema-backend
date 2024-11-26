package it.bebra.cinema.gateway.repository;

import it.bebra.cinema.gateway.mapper.SessionMapper;
import it.bebra.cinema.usecase.port.out.SessionRepository;
import it.bebra.cinema.database.repository.JpaSessionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {
    private final JpaSessionRepository jpaSessionRepository;
    private final SessionMapper sessionMapper;


}
