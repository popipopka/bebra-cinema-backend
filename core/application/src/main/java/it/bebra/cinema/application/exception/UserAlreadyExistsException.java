package it.bebra.cinema.application.exception;

public class UserAlreadyExistsException extends RuntimeException {
    private static final String ALREADY_EXISTS_BY_USERNAME = "User with username = %s already exists";

    public UserAlreadyExistsException(String username) {
        super(ALREADY_EXISTS_BY_USERNAME.formatted(username));
    }
}
