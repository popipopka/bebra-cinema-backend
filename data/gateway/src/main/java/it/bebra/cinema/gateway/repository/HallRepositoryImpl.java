package it.bebra.cinema.gateway.repository;

import it.bebra.cinema.database.repository.JpaHallRepository;
import it.bebra.cinema.gateway.mapper.GatewayHallMapper;
import it.bebra.cinema.usecase.port.out.HallRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HallRepositoryImpl implements HallRepository {
    private final JpaHallRepository jpaHallRepository;
    private final GatewayHallMapper hallMapper;


}
