package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.response.MovieDetailResponseDto;

public interface GetMovieInputPort {
    MovieDetailResponseDto invoke(int id);
}
