package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.MovieDetailResponseDto;

public interface GetMovieInputPort {
    MovieDetailResponseDto invoke(int id);
}
