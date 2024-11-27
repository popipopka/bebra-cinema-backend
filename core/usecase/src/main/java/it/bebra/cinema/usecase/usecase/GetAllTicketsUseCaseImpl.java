package it.bebra.cinema.usecase.usecase;

import it.bebra.cinema.usecase.dto.TicketListResponseDto;
import it.bebra.cinema.usecase.mapper.DomainTicketMapper;
import it.bebra.cinema.usecase.port.in.GetAllTicketsUseCase;
import it.bebra.cinema.usecase.port.out.TicketRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class GetAllTicketsUseCaseImpl implements GetAllTicketsUseCase {
    private final TicketRepository ticketRepository;
    private final DomainTicketMapper ticketMapper;

    @Override
    public List<TicketListResponseDto> invoke(String username) {
        return ticketRepository.findAllByUserUsername(username)
                .stream()
                .map(ticketMapper::toListDto)
                .sorted(Comparator.comparing(TicketListResponseDto::getSessionStartTime))
                .toList();
    }
}
