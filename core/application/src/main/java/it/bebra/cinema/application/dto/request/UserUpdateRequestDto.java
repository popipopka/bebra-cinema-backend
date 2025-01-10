package it.bebra.cinema.application.dto.request;

import lombok.Data;

@Data
public class UserUpdateRequestDto {
    private String firstName;

    private String lastName;

    private String email;
}
