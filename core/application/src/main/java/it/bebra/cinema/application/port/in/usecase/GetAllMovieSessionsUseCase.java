package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.mapper.DomainSessionMapper;
import it.bebra.cinema.application.dto.response.SessionListResponseDto;
import it.bebra.cinema.application.port.in.GetAllMovieSessionsInputPort;
import it.bebra.cinema.application.port.out.SessionOutputPort;
import it.bebra.cinema.domain.Session;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllMovieSessionsUseCase implements GetAllMovieSessionsInputPort {
    private final SessionOutputPort sessionOutputPort;

    private final DomainSessionMapper sessionMapper;

    @Override
    public List<SessionListResponseDto> invoke(int movieId) {
        return sessionOutputPort.findAllUpcomingWithEmptySeatsByMovieId(movieId)
                .stream()
                .sorted(Comparator.comparing(Session::getStartTime))
                .map(sessionMapper::toListDto)
                .toList();
    }
}
