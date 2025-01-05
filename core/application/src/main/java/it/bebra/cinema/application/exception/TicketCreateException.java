package it.bebra.cinema.application.exception;

import lombok.Getter;

@Getter
public class TicketCreateException extends RuntimeException {
    public static final String SESSION_ALREADY_STARTED_MESSAGE = "Session with id = %d has already started";
    public static final String NO_EMPTY_SEATS_FOR_SESSION_MESSAGE = "No empty seats for session with id = %d";

    private final int sessionId;

    private TicketCreateException(String message, int sessionId) {
        super(message.formatted(sessionId));

        this.sessionId = sessionId;
    }

    public static TicketCreateException sessionAlreadyStarted(int sessionId) {
        return new TicketCreateException(SESSION_ALREADY_STARTED_MESSAGE, sessionId);
    }

    public static TicketCreateException noEmptySeatsForSession(int sessionId) {
        return new TicketCreateException(NO_EMPTY_SEATS_FOR_SESSION_MESSAGE, sessionId);
    }
}
