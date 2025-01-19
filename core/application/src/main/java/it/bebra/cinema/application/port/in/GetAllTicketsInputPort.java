package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.data.TicketData;
import it.bebra.cinema.application.dto.page.KeysetPage;

public interface GetAllTicketsInputPort {
    KeysetPage<TicketData> invoke(String username, Integer lastId, int limit);
}
