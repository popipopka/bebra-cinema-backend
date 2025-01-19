package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.data.MovieData;
import it.bebra.cinema.application.dto.page.KeysetPage;

public interface GetAllMoviesInputPort {
    KeysetPage<MovieData> invoke(Integer lastId, int limit, String query);
}
