package it.bebra.cinema.application.exception;

public class MovieNotFoundException extends RuntimeException {
    private static final String NOT_FOUND_BY_ID_MESSAGE = "Movie with id = %d not found";

    public MovieNotFoundException(int id) {
        super(NOT_FOUND_BY_ID_MESSAGE.formatted(id));
    }
}
