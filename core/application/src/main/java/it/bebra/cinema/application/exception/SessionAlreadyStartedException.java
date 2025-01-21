package it.bebra.cinema.application.exception;

import lombok.Getter;

@Getter
public class SessionAlreadyStartedException extends RuntimeException {
    public static final String SESSION_ALREADY_STARTED_MESSAGE = "Session with id = %d has already started";

    public SessionAlreadyStartedException(int sessionId) {
        super(SESSION_ALREADY_STARTED_MESSAGE.formatted(sessionId));
    }
}
