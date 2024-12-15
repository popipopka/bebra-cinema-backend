package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.MovieListResponseDto;

import java.util.List;

public interface GetAllMoviesInputPort {
    List<MovieListResponseDto> invoke();
}
