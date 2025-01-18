package it.bebra.cinema.application.dto.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketData {
    private int id;

    private SessionData session;

    private UserData user;

    private int row;

    private int place;

    private double totalPrice;
}
