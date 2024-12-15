package it.bebra.cinema.application.dto;

import lombok.Data;

@Data
public class UserAuthRequestDto {
    private String username;

    private String password;
}
