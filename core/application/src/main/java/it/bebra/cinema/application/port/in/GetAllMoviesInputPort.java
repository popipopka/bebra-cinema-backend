package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.page.KeysetPageDto;
import it.bebra.cinema.application.dto.response.MovieListResponseDto;

import java.util.Optional;

public interface GetAllMoviesInputPort {
    KeysetPageDto<MovieListResponseDto> invoke(Optional<Integer> lastId, int limit, String query);
}
