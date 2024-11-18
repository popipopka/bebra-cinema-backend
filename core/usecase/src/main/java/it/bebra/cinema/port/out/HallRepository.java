package it.bebra.cinema.port.out;

import it.bebra.cinema.model.Hall;

import java.util.List;
import java.util.Optional;

public interface HallRepository {
    Hall save(Hall hall);

    Optional<Hall> findById(int id);

    List<Hall> findAll();

    void deleteById(int id);

    boolean existsById(int id);
}
