package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.SessionListResponseDto;

import java.util.List;

public interface GetAllSessionsInputPort {
    List<SessionListResponseDto> invoke(int movieId);
}
