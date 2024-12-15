package it.bebra.cinema.application.port.out;

import it.bebra.cinema.domain.Session;

import java.util.List;

public interface SessionOutputPort {
    List<Session> findAllSessionsByMovieId(int movieId);
}
