package it.bebra.cinema.application.port.out;

import it.bebra.cinema.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieOutputPort {
    List<Movie> findAllMovies();

    Optional<Movie> findMovieById(int id);
}
