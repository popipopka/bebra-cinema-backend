package it.bebra.cinema.usecase.dto;

import lombok.Data;

@Data
public class UserAuthRequestDto {
    private String username;

    private String password;
}
