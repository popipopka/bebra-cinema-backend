package it.bebra.cinema.application.port.out;

import it.bebra.cinema.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieOutputPort {
    List<Movie> findAllForKeysetPagination(int id, int limit, String query);

    Optional<Movie> findById(int id);

    boolean existsForKeysetPagination(int id);
}
