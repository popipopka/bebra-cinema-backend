package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.request.TicketCreateRequestDto;

public interface CreateTicketInputPort {
    int invoke(String username, TicketCreateRequestDto request);
}
