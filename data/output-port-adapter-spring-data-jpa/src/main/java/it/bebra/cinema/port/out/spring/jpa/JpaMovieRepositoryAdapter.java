package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.database.spring.jpa.repository.JpaMovieRepository;
import it.bebra.cinema.domain.Movie;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaMovieMapper;
import it.bebra.cinema.application.port.out.MovieOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaMovieRepositoryAdapter implements MovieOutputPort {
    private final JpaMovieRepository jpaMovieRepository;
    private final JpaMovieMapper movieMapper;

    @Override
    public List<Movie> findAllMovies() {
        return jpaMovieRepository.findAll()
                .stream()
                .map(movieMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Movie> findMovieById(int id) {
        return jpaMovieRepository.findById(id)
                .map(movieMapper::toDomain);
    }
}
