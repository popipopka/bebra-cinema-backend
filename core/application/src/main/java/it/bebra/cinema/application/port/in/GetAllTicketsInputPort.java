package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.data.TicketData;
import it.bebra.cinema.application.dto.page.KeysetPage;

import java.util.Optional;

public interface GetAllTicketsInputPort {
    KeysetPage<TicketData> invoke(String username, Optional<Integer> lastId, int limit);
}
