package it.bebra.cinema.application.dto.request;

import lombok.Data;

@Data
public class TicketCreateRequestDto {
    private int sessionId;

    private int row;

    private int place;
}
