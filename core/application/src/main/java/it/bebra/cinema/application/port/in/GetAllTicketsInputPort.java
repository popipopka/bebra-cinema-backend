package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.TicketListResponseDto;

import java.util.List;

public interface GetAllTicketsInputPort {
    List<TicketListResponseDto> invoke(String username);
}
