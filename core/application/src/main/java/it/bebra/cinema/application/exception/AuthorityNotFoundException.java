package it.bebra.cinema.application.exception;

public class AuthorityNotFoundException extends RuntimeException {
    private static final String NOT_FOUND_BY_NAME_MESSAGE = "Authority with name = %s not found";

    public AuthorityNotFoundException(String name) {
        super(NOT_FOUND_BY_NAME_MESSAGE.formatted(name));
    }
}
