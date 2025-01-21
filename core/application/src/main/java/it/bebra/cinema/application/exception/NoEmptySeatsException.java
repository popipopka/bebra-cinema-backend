package it.bebra.cinema.application.exception;

public class NoEmptySeatsException extends RuntimeException {
    public static final String NO_EMPTY_SEATS_FOR_SESSION_MESSAGE = "No empty seats for session with id = %d";

    public NoEmptySeatsException(int sessionId) {
        super(NO_EMPTY_SEATS_FOR_SESSION_MESSAGE.formatted(sessionId));
    }
}
