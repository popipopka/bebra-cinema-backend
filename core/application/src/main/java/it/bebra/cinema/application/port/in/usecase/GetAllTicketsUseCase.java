package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.data.TicketData;
import it.bebra.cinema.application.dto.page.KeysetPage;
import it.bebra.cinema.application.mapper.DomainTicketMapper;
import it.bebra.cinema.application.port.in.GetAllTicketsInputPort;
import it.bebra.cinema.application.port.out.TicketOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static it.bebra.cinema.application.dto.page.TicketKeysetCursors.LAST_ID;

@RequiredArgsConstructor
public class GetAllTicketsUseCase implements GetAllTicketsInputPort {
    private final TicketOutputPort ticketOutputPort;
    private final DomainTicketMapper ticketMapper;

    @Override
    public KeysetPage<TicketData> invoke(String username, Integer lastId, int limit) {
        int notNullLastId = Optional.ofNullable(lastId).orElse(Integer.MAX_VALUE);

        var tickets = getListWithTicketData(username, notNullLastId, limit);

        if (tickets.isEmpty()) {
            return new KeysetPage<>(tickets, null, false);
        }

        int newLastId = tickets.get(tickets.size() - 1).getId();
        boolean hasMore = ticketOutputPort.existsByUserUsernameAndIdLessThan(username, newLastId);

        return new KeysetPage<>(tickets, Map.of(LAST_ID.getValue(), newLastId), hasMore);
    }

    private List<TicketData> getListWithTicketData(String username, int lastId, int limit) {
        return ticketOutputPort.findAllByUserUsername(username, lastId, limit)
                .stream()
                .map(ticketMapper::toData)
                .toList();
    }
}
