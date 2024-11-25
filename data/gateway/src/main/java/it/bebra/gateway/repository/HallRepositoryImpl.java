package it.bebra.gateway.repository;

import it.bebra.usecase.port.out.HallRepository;
import it.bebra.database.repository.JpaHallRepository;
import it.bebra.gateway.mapper.HallMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HallRepositoryImpl implements HallRepository {
    private final JpaHallRepository jpaHallRepository;
    private final HallMapper hallMapper;


}
