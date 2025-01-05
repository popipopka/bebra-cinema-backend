package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.page.KeysetPageDto;
import it.bebra.cinema.application.dto.page.TicketKeysetCursors;
import it.bebra.cinema.application.dto.response.TicketListResponseDto;
import it.bebra.cinema.application.mapper.DomainTicketMapper;
import it.bebra.cinema.application.port.in.GetAllTicketsInputPort;
import it.bebra.cinema.application.port.out.TicketOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static it.bebra.cinema.application.dto.page.TicketKeysetCursors.*;

@RequiredArgsConstructor
public class GetAllTicketsUseCase implements GetAllTicketsInputPort {
    private final TicketOutputPort ticketOutputPort;
    private final DomainTicketMapper ticketMapper;

    @Override
    public KeysetPageDto<TicketListResponseDto> invoke(String username, Optional<Integer> lastId, int limit) {
        var tickets = getListWithTicketListResponseDto(username, lastId.orElse(Integer.MAX_VALUE), limit);

        if (tickets.isEmpty()) {
            return new KeysetPageDto<>(tickets, null, false);
        }

        int newLastId = tickets.get(tickets.size() - 1).getId();
        boolean hasMore = ticketOutputPort.existsByUserUsernameAndIdLessThan(username, newLastId);

        return new KeysetPageDto<>(tickets, Map.of(LAST_ID.getValue(), newLastId), hasMore);
    }

    private List<TicketListResponseDto> getListWithTicketListResponseDto(String username, int lastId, int limit) {
        return ticketOutputPort.findAllByUserUsername(username, lastId, limit)
                .stream()
                .map(ticketMapper::toListDto)
                .toList();
    }
}
