package it.bebra.cinema.repository;

import it.bebra.cinema.port.out.MovieRepository;
import it.bebra.cinema.repository.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {
    private final JpaMovieRepository jpaMovieRepository;
    private final MovieMapper movieMapper;


}
