package it.bebra.cinema.port.in.spring.webmvc.controller.handler;

import it.bebra.cinema.application.exception.*;
import it.bebra.cinema.security.jwt.exception.JwtAuthenticationException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldConstraintViolation> violations = ex.getFieldErrors()
                .stream()
                .map(e ->
                        FieldConstraintViolation.of(e.getField(), e.getDefaultMessage())
                )
                .toList();

        ProblemDetail problemDetail = ProblemDetail.forStatus(ex.getStatusCode());
        problemDetail.setProperty("violations", violations);

        return ResponseEntity
                .of(problemDetail)
                .build();
    }

    @ExceptionHandler(JwtAuthenticationException.class)
    public ResponseEntity<ProblemDetail> handleJwtAuthenticationException(JwtAuthenticationException ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(TicketDeleteException.class)
    public ResponseEntity<ProblemDetail> handleTicketDeleteException(TicketDeleteException ex) {
        return buildResponseEntity(HttpStatus.FORBIDDEN, ex.getMessage());
    }

    @ExceptionHandler(TooCloseToSessionException.class)
    public ResponseEntity<ProblemDetail> handleTooCloseToSessionException(TooCloseToSessionException ex) {
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

    @ExceptionHandler(SessionAlreadyStartedException.class)
    public ResponseEntity<ProblemDetail> handleSessionAlreadyStartedException(SessionAlreadyStartedException ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(NoEmptySeatsException.class)
    public ResponseEntity<ProblemDetail> handleNoEmptySeatsException(NoEmptySeatsException ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ProblemDetail> handleConstraintViolationException(ConstraintViolationException ex) {
        List<FieldConstraintViolation> violations = ex.getConstraintViolations().stream()
                .map(e ->
                        FieldConstraintViolation.of(
                                e.getPropertyPath().toString(),
                                e.getMessage()
                        )
                )
                .toList();

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setProperty("violations", violations);

        return ResponseEntity
                .of(problemDetail)
                .build();
    }

    private ResponseEntity<ProblemDetail> buildResponseEntity(HttpStatus httpStatus, String message) {
        return ResponseEntity
                .of(ProblemDetail
                        .forStatusAndDetail(httpStatus, message))
                .build();
    }
}
