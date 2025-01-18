package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.request.TicketCreateRequest;

public interface CreateTicketInputPort {
    int invoke(String username, TicketCreateRequest request);
}
