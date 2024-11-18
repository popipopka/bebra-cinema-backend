package it.bebra.gateway.repository;

import it.bebra.database.entity.JpaMovie;
import it.bebra.domain.model.Movie;
import it.bebra.database.repository.JpaMovieRepository;
import it.bebra.gateway.repository.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import port.out.MovieRepository;

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
