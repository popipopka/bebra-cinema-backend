package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.MovieDetailResponseDto;
import it.bebra.cinema.application.exception.MovieNotFoundException;
import it.bebra.cinema.application.mapper.DomainMovieMapper;
import it.bebra.cinema.application.port.in.GetMovieInputPort;
import it.bebra.cinema.application.port.out.MovieOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetMovieUseCase implements GetMovieInputPort {
    private final MovieOutputPort movieOutputPort;

    private final DomainMovieMapper domainMovieMapper;

    @Override
    public MovieDetailResponseDto invoke(int id) {
        return movieOutputPort.findMovieById(id)
                .map(domainMovieMapper::toDetailDto)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }
}
