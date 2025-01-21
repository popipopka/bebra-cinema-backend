package it.bebra.cinema.application.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketDeleteException extends RuntimeException {
    private static final String NOT_BELONG_TO_USER_MESSAGE
            = "A ticket with id = %d does not belong to a user with username = %s";

    public TicketDeleteException(String username, int ticketId) {
        super(NOT_BELONG_TO_USER_MESSAGE.formatted(ticketId, username));
    }
}
