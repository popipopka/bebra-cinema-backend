package it.bebra.cinema.usecase.dto;

import lombok.Data;

@Data
public class UserCreateRequestDto {
    private String username;
    private String password;
}
