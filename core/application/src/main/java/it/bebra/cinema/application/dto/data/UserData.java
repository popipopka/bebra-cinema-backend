package it.bebra.cinema.application.dto.data;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UserData {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private Instant createdTime;

    private Instant updatedTime;

    private List<String> authorities;
}
