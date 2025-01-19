package it.bebra.cinema.port.in.spring.webmvc.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class FieldConstraintViolation {
    private String field;

    private String message;
}
