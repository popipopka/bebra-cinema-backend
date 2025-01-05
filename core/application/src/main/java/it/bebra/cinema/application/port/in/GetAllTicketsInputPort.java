package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.page.KeysetPageDto;
import it.bebra.cinema.application.dto.response.TicketListResponseDto;

import java.util.Optional;

public interface GetAllTicketsInputPort {
    KeysetPageDto<TicketListResponseDto> invoke(String username, Optional<Integer> lastId, int limit);
}
