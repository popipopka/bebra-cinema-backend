package it.bebra.cinema.application.exception;

public class UserNotFoundException extends RuntimeException {
    private static final String NOT_FOUND_BY_USERNAME = "User with username = %s not found";

    public UserNotFoundException(String username) {
        super(NOT_FOUND_BY_USERNAME.formatted(username));
    }
}
