package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.data.MovieData;

public interface GetMovieInputPort {
    MovieData invoke(int id);
}
