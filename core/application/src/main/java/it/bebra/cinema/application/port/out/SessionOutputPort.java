package it.bebra.cinema.application.port.out;

import it.bebra.cinema.domain.Session;

import java.util.List;
import java.util.Optional;

public interface SessionOutputPort {
    List<Session> findAllUpcomingWithEmptySeatsByMovieId(int movieId);

    Optional<Session> findById(int id);
}
