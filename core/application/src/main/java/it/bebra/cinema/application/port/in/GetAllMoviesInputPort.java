package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.data.MovieData;
import it.bebra.cinema.application.dto.page.KeysetPage;

import java.util.Optional;

public interface GetAllMoviesInputPort {
    KeysetPage<MovieData> invoke(Optional<Integer> lastId, int limit, String query);
}
