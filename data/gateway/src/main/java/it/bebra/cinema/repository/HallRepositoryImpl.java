package it.bebra.cinema.repository;

import it.bebra.cinema.port.out.HallRepository;
import it.bebra.cinema.repository.mapper.HallMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HallRepositoryImpl implements HallRepository {
    private final JpaHallRepository jpaHallRepository;
    private final HallMapper hallMapper;


}
