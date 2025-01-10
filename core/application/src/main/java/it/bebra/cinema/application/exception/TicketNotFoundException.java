package it.bebra.cinema.application.exception;

public class TicketNotFoundException extends RuntimeException {
    private static final String NOT_FOUND_BY_ID_MESSAGE = "Ticket with id = %d not found";

    public TicketNotFoundException(int ticketId) {
        super(NOT_FOUND_BY_ID_MESSAGE.formatted(ticketId));
    }
}
