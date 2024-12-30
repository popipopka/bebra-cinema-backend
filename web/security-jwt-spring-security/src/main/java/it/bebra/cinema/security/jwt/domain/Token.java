package it.bebra.cinema.security.jwt.domain;

import it.bebra.cinema.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Token {
    private Integer id;

    private User user;

    private String value;
}
