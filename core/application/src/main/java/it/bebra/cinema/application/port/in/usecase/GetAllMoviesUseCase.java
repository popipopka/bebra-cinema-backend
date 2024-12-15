package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.MovieListResponseDto;
import it.bebra.cinema.application.mapper.DomainMovieMapper;
import it.bebra.cinema.application.port.in.GetAllMoviesInputPort;
import it.bebra.cinema.application.port.out.MovieOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllMoviesUseCase implements GetAllMoviesInputPort {
    private final MovieOutputPort movieOutputPort;

    private final DomainMovieMapper domainMovieMapper;

    @Override
    public List<MovieListResponseDto> invoke() {
        return movieOutputPort.findAllMovies()
                .stream()
                .map(domainMovieMapper::toListDto)
                .toList();
    }
}
