package it.bebra.cinema.repository;

import it.bebra.cinema.entity.JpaHall;
import it.bebra.cinema.model.Hall;
import it.bebra.cinema.port.out.HallRepository;
import it.bebra.cinema.repository.mapper.HallMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class HallRepositoryImpl implements HallRepository {
    private final JpaHallRepository jpaHallRepository;
    private final HallMapper hallMapper;

    @Override
    public Hall save(Hall hall) {
        JpaHall jpaHall = hallMapper.toEntity(hall);

        jpaHall = jpaHallRepository.save(jpaHall);

        return hallMapper.toDomain(jpaHall);
    }

    @Override
    public Optional<Hall> findById(int id) {
        return jpaHallRepository.findById(id)
                .map(hallMapper::toDomain);

    }

    @Override
    public List<Hall> findAll() {
        return jpaHallRepository.findAll().stream()
                .map(hallMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        jpaHallRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return jpaHallRepository.existsById(id);
    }
}
