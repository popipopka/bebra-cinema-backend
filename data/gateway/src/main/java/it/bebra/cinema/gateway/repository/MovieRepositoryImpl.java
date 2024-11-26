package it.bebra.cinema.gateway.repository;

import it.bebra.cinema.database.repository.JpaMovieRepository;
import it.bebra.cinema.gateway.mapper.MovieMapper;
import it.bebra.cinema.usecase.port.out.MovieRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {
    private final JpaMovieRepository jpaMovieRepository;
    private final MovieMapper movieMapper;


}
