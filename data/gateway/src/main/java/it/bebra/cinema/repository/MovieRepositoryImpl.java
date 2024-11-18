package it.bebra.cinema.repository;

import it.bebra.cinema.entity.JpaMovie;
import it.bebra.cinema.model.Movie;
import it.bebra.cinema.port.out.MovieRepository;
import it.bebra.cinema.repository.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {
    private final JpaMovieRepository jpaMovieRepository;
    private final MovieMapper movieMapper;

    @Override
    public Movie save(Movie movie) {
        JpaMovie jpaMovie = movieMapper.toEntity(movie);

        jpaMovie = jpaMovieRepository.save(jpaMovie);

        return movieMapper.toDomain(jpaMovie);
    }

    @Override
    public Optional<Movie> findById(int id) {
        return jpaMovieRepository.findById(id)
                .map(movieMapper::toDomain);
    }

    @Override
    public List<Movie> findAll() {
        return jpaMovieRepository.findAll().stream()
                .map(movieMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        jpaMovieRepository.deleteById(id);
    }
}
