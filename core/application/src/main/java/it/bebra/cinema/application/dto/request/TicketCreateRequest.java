package it.bebra.cinema.application.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class TicketCreateRequest {

    @Min(1)
    private int sessionId;

    @Min(1)
    private int row;

    @Min(1)
    private int place;
}
