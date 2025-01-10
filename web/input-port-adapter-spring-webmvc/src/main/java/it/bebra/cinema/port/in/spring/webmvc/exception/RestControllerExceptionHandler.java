package it.bebra.cinema.port.in.spring.webmvc.exception;

import it.bebra.cinema.application.exception.*;
import it.bebra.cinema.security.jwt.exception.JwtAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static it.bebra.cinema.application.exception.TicketCreateException.*;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(JwtAuthenticationException.class)
    public ResponseEntity<ProblemDetail> handleJwtAuthenticationException(JwtAuthenticationException ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(TicketDeleteException.class)
    public ResponseEntity<ProblemDetail> handleTicketDeleteException(TicketDeleteException ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleUserNotFoundException(UserNotFoundException ex) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleTicketNotFoundException(TicketNotFoundException ex) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleMovieNotFoundException(MovieNotFoundException ex) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(SessionNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleSessionNotFoundException(SessionNotFoundException ex) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return buildResponseEntity(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler(TicketCreateException.class)
    public ResponseEntity<ProblemDetail> handleTicketCreateException(TicketCreateException ex) {
        HttpStatus httpStatus = determineHttpStatusForTicketCreateException(ex);

        return buildResponseEntity(httpStatus, ex.getMessage());
    }

    private HttpStatus determineHttpStatusForTicketCreateException(TicketCreateException exception) {
        if (isExpectedMessage(exception, SESSION_ALREADY_STARTED_MESSAGE)) {
            return HttpStatus.CONFLICT;

        } else if (isExpectedMessage(exception, NO_EMPTY_SEATS_FOR_SESSION_MESSAGE)) {
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private boolean isExpectedMessage(TicketCreateException exception, String expected) {
        return expected.formatted(exception.getSessionId()).equals(exception.getMessage());
    }

    private ResponseEntity<ProblemDetail> buildResponseEntity(HttpStatus httpStatus, String message) {
        return ResponseEntity
                .of(ProblemDetail
                        .forStatusAndDetail(httpStatus, message))
                .build();
    }
}
