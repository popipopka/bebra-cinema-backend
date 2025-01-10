package it.bebra.cinema.application.exception;

import java.time.temporal.ChronoUnit;

public class TicketDeleteException extends RuntimeException {
    private static final String LESS_THAN_UNTIL_SESSION_START_MESSAGE
            = "There is less than %d %s until session with id = %d start";
    private static final String NOT_BELONG_TO_USER_MESSAGE
            = "A ticket with id = %d does not belong to a user with username = %s";

    public TicketDeleteException(int startTimeLimit, ChronoUnit limitUnit, int sessionId) {
        super(LESS_THAN_UNTIL_SESSION_START_MESSAGE.formatted(startTimeLimit, limitUnit.name(), sessionId));
    }

    public TicketDeleteException(String username, int ticketId) {
        super(NOT_BELONG_TO_USER_MESSAGE.formatted(ticketId, username));
    }
}
