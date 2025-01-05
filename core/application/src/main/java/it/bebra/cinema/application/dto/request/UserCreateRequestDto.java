package it.bebra.cinema.application.dto.request;

import lombok.Data;

@Data
public class UserCreateRequestDto {
    private String firstName;

    private String lastName;
    
    private String email;

    private String username;

    private String password;
}
