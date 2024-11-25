package it.bebra.gateway.repository;

import it.bebra.usecase.port.out.MovieRepository;
import it.bebra.database.repository.JpaMovieRepository;
import it.bebra.gateway.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {
    private final JpaMovieRepository jpaMovieRepository;
    private final MovieMapper movieMapper;


}
