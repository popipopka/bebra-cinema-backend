package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.response.SessionListResponseDto;

import java.util.List;

public interface GetAllMovieSessionsInputPort {
    List<SessionListResponseDto> invoke(int movieId);
}
