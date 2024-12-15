package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.TicketListResponseDto;
import it.bebra.cinema.application.mapper.DomainTicketMapper;
import it.bebra.cinema.application.port.in.GetAllTicketsInputPort;
import it.bebra.cinema.application.port.out.TicketOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllTicketsUseCase implements GetAllTicketsInputPort {
    private final TicketOutputPort ticketOutputPort;
    private final DomainTicketMapper ticketMapper;

    @Override
    public List<TicketListResponseDto> invoke(String username) {
        return ticketOutputPort.findAllTicketsByUserUsername(username)
                .stream()
                .map(ticketMapper::toListDto)
                .sorted(Comparator.comparing(TicketListResponseDto::getSessionStartTime))
                .toList();
    }
}
