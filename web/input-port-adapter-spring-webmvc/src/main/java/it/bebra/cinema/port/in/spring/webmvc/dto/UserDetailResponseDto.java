package it.bebra.cinema.port.in.spring.webmvc.dto;

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
