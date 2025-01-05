package it.bebra.cinema.application.dto.response;

import lombok.Data;

import java.time.Instant;

@Data
public class UserDetailResponseDto {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private Instant createdTime;

    private Instant updatedTime;
}
