package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.persistence.database.spring.jpa.repository.JpaMovieRepository;
import it.bebra.cinema.domain.Movie;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaMovieMapper;
import it.bebra.cinema.application.port.out.MovieOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaMovieRepositoryAdapter implements MovieOutputPort {
    private final JpaMovieRepository jpaMovieRepository;
    private final JpaMovieMapper movieMapper;

    @Override
    public List<Movie> findAllForKeysetPagination(int id, int limit, String query) {
        return jpaMovieRepository.findAllForKeysetPaginationByNameLike(id, limit, query)
                .stream()
                .map(movieMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Movie> findById(int id) {
        return jpaMovieRepository.findById(id)
                .map(movieMapper::toDomain);
    }

    @Override
    public boolean existsForKeysetPagination(int id) {
        return jpaMovieRepository.existsForKeysetPagination(id);
    }
}
