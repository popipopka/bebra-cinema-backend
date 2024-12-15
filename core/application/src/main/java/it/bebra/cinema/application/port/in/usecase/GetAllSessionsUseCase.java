package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.mapper.DomainSessionMapper;
import it.bebra.cinema.application.dto.SessionListResponseDto;
import it.bebra.cinema.application.port.in.GetAllSessionsInputPort;
import it.bebra.cinema.application.port.out.SessionOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllSessionsUseCase implements GetAllSessionsInputPort {
    private final SessionOutputPort sessionOutputPort;

    private final DomainSessionMapper sessionMapper;

    @Override
    public List<SessionListResponseDto> invoke(int movieId) {
        return sessionOutputPort.findAllSessionsByMovieId(movieId)
                .stream()
                .map(sessionMapper::toListDto)
                .toList();
    }
}
