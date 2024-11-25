package it.bebra.cinema.usecase.port.in;

import it.bebra.cinema.usecase.dto.TicketListResponseDto;

import java.util.List;

public interface GetAllTicketsUseCase {
    List<TicketListResponseDto> invoke(String username);
}
