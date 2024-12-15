package it.bebra.cinema.application.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(int id) {
        super("Movie with id = %d not found".formatted(id));
    }
}
