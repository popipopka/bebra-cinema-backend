package it.bebra.cinema.application.exception;

import java.time.temporal.ChronoUnit;

public class TooCloseToSessionException extends RuntimeException {
    private static final String LESS_THAN_UNTIL_SESSION_START_MESSAGE
            = "There is less than %d %s until session with id = %d start";

    public TooCloseToSessionException(int startTimeLimit, ChronoUnit limitUnit, int sessionId) {
        super(LESS_THAN_UNTIL_SESSION_START_MESSAGE.formatted(startTimeLimit, limitUnit, sessionId));
    }
}
