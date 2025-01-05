package it.bebra.cinema.application.exception;

public class SessionNotFoundException extends RuntimeException {
    private static final String NOT_FOUND_BY_ID_MESSAGE = "Session with id = %d not found";

    public SessionNotFoundException(int id) {
        super(NOT_FOUND_BY_ID_MESSAGE.formatted(id));
    }
}
