package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.data.SessionData;

import java.util.List;

public interface GetAllMovieSessionsInputPort {
    List<SessionData> invoke(int movieId);
}
