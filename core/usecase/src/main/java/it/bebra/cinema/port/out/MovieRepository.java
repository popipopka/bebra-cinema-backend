package it.bebra.cinema.port.out;

import it.bebra.cinema.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    Movie save(Movie movie);

    Optional<Movie> findById(int id);

    List<Movie> findAll();

    void deleteById(int id);
}
